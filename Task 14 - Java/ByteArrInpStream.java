import java.io.ByteArrayInputStream;
import java.io.IOException;
//import java.util.*;
import java.util.Arrays;

public class ByteArrInpStream {
  public static void main(String[] args) throws IOException {

    byte[] buff = { 35, 36, 37, 38 };

    ByteArrayInputStream byt = new ByteArrayInputStream(buff);

    System.out.println("Before reading: " + byt.available());

    // Printing the byte ByteArrayInputStream
    for (int i = 0; i < buff.length - 2; i++) {
      int input = byt.read();
      System.out.println(input);
    }

    // Available method
    System.out.println("After Reading: " + byt.available());

    // Skip Method
    byte[] byteArr = { 1, 2, 3, 4 };
    System.out.println("Initial Array: " + Arrays.toString(byteArr));
    ByteArrayInputStream bytArr = new ByteArrayInputStream(byteArr);
    bytArr.skip(2);
    int d = bytArr.read();
    while (d != -1) {
      System.out.println("Skipped 2 elements using skip: " + d);
      d = bytArr.read();
    }

    // Finally close the stream
    bytArr.close();
    byt.close();
  }
}
