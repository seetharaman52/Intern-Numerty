import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {
  public static void main(String[] args) throws IOException {

    // Check file1.txt
    FileInputStream fis = new FileInputStream("file1.txt");
    DataInputStream dis = new DataInputStream(fis);
    int count = fis.available();
    byte[] arr = new byte[count];
    dis.read(arr);
    System.out.print("Text in file1.txt: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print((char) arr[i]);
    }
    dis.close();
    fis.close();

    // Check file2.txt
    FileInputStream fis2 = new FileInputStream("file2.txt");
    DataInputStream dis2 = new DataInputStream(fis2);
    int count2 = fis2.available();
    byte[] fis2arr = new byte[count2];
    dis2.read(fis2arr);
    System.out.print("Text in file2.txt: ");
    for (int i = 0; i < fis2arr.length; i++) {
      System.out.print((char) fis2arr[i]);
    }
    dis2.close();
    fis2.close();

    // Writing to file2.txt
    FileOutputStream fos = new FileOutputStream("file2.txt");
    DataOutputStream dos = new DataOutputStream(fos);
    dos.writeUTF("I changed the text in file2.txt\n");
    dos.close();
    fos.close();

    // Checking file2.txt now
    FileInputStream fis3 = new FileInputStream("file2.txt");
    DataInputStream dis3 = new DataInputStream(fis3);
    int count3 = fis3.available();
    byte[] fis3arr = new byte[count3];
    dis3.read(fis3arr);
    System.out.print("Text in file2.txt after modification: ");
    for (int i = 0; i < fis3arr.length; i++) {
      System.out.print((char) fis3arr[i]);
    }
    dis3.close();
    fis3.close();

  }
}
