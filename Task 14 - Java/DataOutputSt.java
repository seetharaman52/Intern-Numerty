import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputSt {
  public static void main(String[] args) throws IOException {
    FileOutputStream fStream = new FileOutputStream("file.txt");
    DataOutputStream f = new DataOutputStream(fStream);
    String str = "Written with Java";
    f.writeChars(str);
    f.flush();
    f.close();

    FileInputStream fiStream = new FileInputStream("file.txt");
    DataInputStream d = new DataInputStream(fiStream);
    int c = d.available();
    byte[] arr = new byte[c];
    d.read(arr);
    for (byte bt : arr) {
      char k = (char) bt;
      System.out.print(k);
    }
    d.close();
  }
}
