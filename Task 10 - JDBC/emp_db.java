import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class emp_db {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/myapp";
            String username = "root";
            String password = "myPASSWORD";
            Connection connection = DriverManager.getConnection(url, username, password);
            if(connection != null){
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to connect to the database");
            }
            Scanner scanner = new Scanner(System.in);
                int choice;
                do {
                    System.out.println("1. Insert");
                    System.out.println("2. Display");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            insertEmployee(connection, scanner);
                            break;
                        case 2:
                            displayEmployees(connection);
                            break;
                        case 3:
                            updateEmployee(connection, scanner);
                            break;
                        case 4:
                            deleteEmployee(connection, scanner);
                            break;
                        case 5:
                            System.out.println("Exiting program.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (choice != 5);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    private static void insertEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Name: ");
        String emp_name = scanner.next();
        System.out.print("Enter Employee Number: ");
        String emp_number = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double emp_salary = scanner.nextDouble();

        String sql = "INSERT INTO employees (emp_name, emp_number, emp_salary) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, emp_name);
            statement.setString(2, emp_number);
            statement.setDouble(3, emp_salary);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee.");
            }
        }
    }

    private static void displayEmployees(Connection connection) throws SQLException {
        String sql = "SELECT * FROM employees";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Employee Name: " + resultSet.getString("emp_name"));
                System.out.println("Employee Number: " + resultSet.getString("emp_number"));
                System.out.println("Employee Salary: " + resultSet.getDouble("emp_salary"));
                System.out.println();
            }
        }
    }

    private static void updateEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter new Employee Name: ");
        String emp_name = scanner.next();
        System.out.print("Enter new Employee Number: ");
        String emp_number = scanner.next();
        System.out.print("Enter new Employee Salary: ");
        double emp_salary = scanner.nextDouble();

        String sql = "UPDATE employees SET emp_name = ?, emp_number = ?, emp_salary = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, emp_name);
            statement.setString(2, emp_number);
            statement.setDouble(3, emp_salary);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee.");
            }
        }
    }

    private static void deleteEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee phone number to delete: ");
        int emp_id = scanner.nextInt();

        String sql = "DELETE FROM employees WHERE emp_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, emp_id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Failed to delete employee.");
            }
        }
    }
}
