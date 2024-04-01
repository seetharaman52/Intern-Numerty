import java.util.*;
// Vector methods
// add()
// addAll()
// addElement()
// capacity()
// clear()
// clone()
// contains()
// containsAll()
// copyInto()
// elementAt()
// elements()
// ensureCapacity()
// equals()
// firstElement()
// get()
// etc..
public class VCist {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        System.out.println(v.add(1));
        v.add(2);
        v.addElement(3);
        // Diff between add and addElement is add returns a boolean
        // addElement returns void
        System.out.println(v);
        System.out.println(v.capacity());
        System.out.println(v.contains(3));
        Integer[] arr = new Integer[3];
        v.copyInto(arr);
        System.out.println(Arrays.toString(arr));
    }
}
