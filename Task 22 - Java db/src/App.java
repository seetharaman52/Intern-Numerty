import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.Scanner;

// For image
class ImageModule{
    // image_table structure:
    // create table image_table(image_id int auto_increment primary key, image_data longblob not null);
    private Connection connection;
    private String query;
    private PreparedStatement pstmt;
    private String HOME_DIR = "/home/seetharaman/";
    public ImageModule() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "2802");
        System.out.println("Connected to Database!");
    }

    // Add image to database
    public void addImage(String path) throws IOException, SQLException, FileNotFoundException{
        try{
            FileInputStream fis = new FileInputStream(path);
            byte[] img_data = new byte[fis.available()];
            fis.read(img_data);
            query = "INSERT INTO image_table(image_data) VALUES(?)";
            pstmt = connection.prepareStatement(query);
            pstmt.setBytes(1, img_data);
            int affectedRows = pstmt.executeUpdate();
            if(affectedRows > 0){System.out.println("Image added successfully!");}
            else{System.out.println("Failed to add image!");}
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    // Get image from database
    public void getImage(int id) throws IOException{
        query = "SELECT image_data FROM image_table WHERE image_id = ?";
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                byte[] img_data = rs.getBytes("image_data");
                String path = HOME_DIR + "extractedImage.jpeg";
                OutputStream os = new FileOutputStream(path);
                os.write(img_data);
                System.out.println("Image extracted successfully!");
                os.close();
            }
            else{
                System.out.println("Image not found!");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    // Delete image from database
    public void deleteImage(int id) throws SQLException{
        query = "DELETE FROM image_table WHERE image_id = ?";
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Image deleted successfully!");
            }
            else{
                System.out.println("Failed to delete image!");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    // Close connection
    public void closeConnection() throws SQLException{
        connection.close();
        System.out.println("Connection closed!");
    }
}


// For folder
class FolderModule{
    private Connection connection;
    private String query;
    private PreparedStatement pstmt;
    private String HOME_DIR = "/home/seetharaman/";
    public FolderModule() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "2802");
        System.out.println("Connected to Database!");
    }

    // Add folder to database
    public void addFolder(String path) throws IOException, SQLException, FileNotFoundException{
        try{
            File folder = new File(path);
            if(!folder.exists() || !folder.isDirectory()){
                System.out.println("Folder not found!");
                return;
            }
            File[] files = folder.listFiles();
            if(files != null){
                for(File file: files){
                    if(file.isFile()){
                        try(FileInputStream fis = new FileInputStream(file)){
                            byte[] fileData = new byte[fis.available()];
                            fis.read(fileData);
                            query = "INSERT INTO folder_table(folder_name, file_name, file_data) VALUES(?, ?, ?)";
                            pstmt = connection.prepareStatement(query);
                            pstmt.setString(1, folder.getName());
                            pstmt.setString(2, file.getName());
                            pstmt.setBytes(3, fileData);
                            int affectedRows = pstmt.executeUpdate();
                            if (affectedRows > 0) {
                                System.out.println("File '" + file.getName() + "' added successfully to folder '" + folder.getName() + "'!");
                            } else {
                                System.out.println("Failed to add file '" + file.getName() + "' to folder '" + folder.getName() + "'!");
                            }
                        }
                        catch(FileNotFoundException e){
                            System.out.println(e);
                        }
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    // Get folder from database
    public void getFolder(String folderName) throws IOException{
        query = "SELECT file_name, file_data FROM folder_table WHERE folder_name = ?";
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, folderName);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String fileName = rs.getString("file_name");
                byte[] fileData = rs.getBytes("file_data");
                String path = HOME_DIR + folderName + "/" + fileName;
                File file = new File(path);
                if(!file.exists()){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                OutputStream os = new FileOutputStream(path);
                os.write(fileData);
                System.out.println("File '" + fileName + "' extracted successfully from folder '" + folderName + "'!");
                os.close();
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    // Delete folder from database
    public void deleteFolder(String folderName) throws SQLException{
        query = "DELETE FROM folder_table WHERE folder_name = ?";
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, folderName);
            int affectedRows = pstmt.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Folder '" + folderName + "' deleted successfully!");
            }
            else{
                System.out.println("Failed to delete folder '" + folderName + "'!");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    // Close connection
    public void closeConnection() throws SQLException{
        connection.close();
        System.out.println("Connection closed!");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        String folderName;
        int id;
        String path;
        System.out.println("Select an option:");
        System.out.println("1. Image");
        System.out.println("2. Folder");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an option: ");
        int option = sc.nextInt();
        switch(option){
            case 1:
                System.out.println("You chose Image");
                ImageModule imageModule = new ImageModule();
                System.out.println("Select an option:");
                System.out.println("1. Add image");
                System.out.println("2. Get image");
                System.out.println("3. Delete image");
                System.out.println("4. Close connection");
                int imageOption = sc.nextInt();
                switch(imageOption){
                    case 1:
                        System.out.println("Enter image path:");
                        path = sc.next();
                        imageModule.addImage(path);
                        break;
                    case 2:
                        System.out.println("Enter image id:");
                        id = sc.nextInt();
                        imageModule.getImage(id);
                        break;
                    case 3:
                        System.out.println("Enter image id");
                        id = sc.nextInt();
                        imageModule.deleteImage(id);
                        break;
                    case 4:
                        imageModule.closeConnection();
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 2:
                System.out.println("You chose Folder");
                FolderModule folderModule = new FolderModule();
                System.out.println("Select an option:");
                System.out.println("1. Add folder");
                System.out.println("2. Get folder");
                System.out.println("3. Delete folder");
                System.out.println("4. Close connection");
                int folderOption = sc.nextInt();
                switch(folderOption){
                    case 1:
                        System.out.println("Enter folder path:");
                        path = sc.next();
                        folderModule.addFolder(path);
                        break;
                    case 2:
                        System.out.println("Enter folder name:");
                        folderName = sc.next();
                        folderModule.getFolder(folderName);
                        break;
                    case 3:
                        System.out.println("Enter folder name:");
                        folderName = sc.next();
                        folderModule.deleteFolder(folderName);
                        break;
                    case 4:
                        folderModule.closeConnection();
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}
