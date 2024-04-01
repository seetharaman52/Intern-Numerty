import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInpStream {
  public static void main(String[] args) throws IOException {
    // Data Input Stream
    InputStream input = new FileInputStream("file.txt");
    DataInputStream inst = new DataInputStream(input);
    // System.out.println(inst);
    int count = input.available();
    System.out.println("Size: " + count);
    byte[] arr = new byte[count];
    inst.read(arr);
    for (byte bt : arr) {
      char k = (char) bt;
      System.out.print(k);
    }
    inst.close();
  }
}
