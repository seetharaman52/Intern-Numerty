import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.util.*;
import java.util.Arrays;

public class ByteArrOutStream {
  public static void main(String[] args) throws IOException {
    // ByteArrayOutputStream
    // There is default size and as well as custom size we can pass to the "new"
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    String data = "Hey I am a Java developer!";
    byte[] arr = data.getBytes();
    System.out.println("Bytes for ref: " + Arrays.toString(arr));
    // Write data to output stream
    out.write(arr);

    // Retrieve data from output stream
    String StreamData = out.toString();
    System.out.println("Output Stream: " + StreamData);

    // Close the stream
    out.close();
    // Flush method clears the output stream
  }
}
