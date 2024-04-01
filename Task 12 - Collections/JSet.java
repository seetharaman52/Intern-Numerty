import java.util.*;
// Common Methods
// add()
// addAll()
// clear()
// contains()
// containsAll()
// equals()
// isEmpty()
// remove()
// removeAll()
// retainAll()
// size()
// toArray()

public class JSet {
    public static void main(String[] args) {

        // Types of Set
        // 1. HashSet
        // 2. LinkedHashSet
        // 3. TreeSet
        // 4. SortedSet
        // 5. NavigableSet

        // HashSet
        System.out.println("\nJava HashSet");
        Set<String> HSet = new HashSet<String>(); 
        HSet.add("Lorem");
        HSet.add("Ipsum");
        HSet.add("Dolor");
        HSet.add("Sit");
        HSet.add("Amet");
        System.out.println("HashSet: " + HSet);

        // Hashset to array
        String[] arr = new String[HSet.size()];
        HSet.toArray(arr);
        System.out.println("Array: " + Arrays.toString(arr));

        // Direct Array to Hashset
        Set<Integer> HsetInt1 = new HashSet<Integer>();
        HsetInt1.addAll(Arrays.asList(new Integer[]{1,2,3,4,5}));

        Set<Integer> HsetInt2 = new HashSet<Integer>();
        HsetInt2.addAll(Arrays.asList(new Integer[]{6,7,8,9,1}));

        // Union
        Set<Integer> union = new HashSet<Integer>(HsetInt1);
        union.addAll(HsetInt2);
        System.out.println("Union: " + union);

        // Intersection
        Set<Integer> intersection = new HashSet<Integer>(HsetInt1);
        intersection.retainAll(HsetInt2);
        System.out.println("Intersection: " + intersection);

        // Difference
        Set<Integer> difference = new HashSet<Integer>(HsetInt1);
        difference.removeAll(HsetInt2);
        System.out.println("Difference: " + difference);

        // Check if a set is a subset of another
        System.out.println("Is HsetInt1 a subset of HsetInt2 ? " + HsetInt2.containsAll(HsetInt1));


        // LinkedHashSet
        System.out.println("\nJava LinkedHashSet");
        Set<String> LHSet = new LinkedHashSet<String>();
        LHSet.add("Lorem");
        LHSet.add("Ipsum");
        LHSet.add("Dolor");
        LHSet.add("Sit");
        LHSet.add("Amet");
        System.out.println("LinkedHashSet: " + LHSet);
        
        // LinkedHashSet to array
        String[] arr2 = new String[LHSet.size()];
        LHSet.toArray(arr2);
        System.out.println("Array: " + Arrays.toString(arr2));

        // Direct Array to LinkedHashset
        Set<Integer> LHsetInt1 = new LinkedHashSet<Integer>();
        LHsetInt1.addAll(Arrays.asList(new Integer[]{1,2,3,4,5}));
        System.out.println(LHsetInt1);

        // TreeSet
        System.out.println("\nJava TreeSet");
        Set<String> TSet = new TreeSet<String>();
        TSet.add("Lorem");
        TSet.add("Ipsum");
        TSet.add("Dolor");
        TSet.add("Sit");
        TSet.add("Amet");
        System.out.println("TreeSet: " + TSet);

        // TreeSet to array
        String[] arr3 = new String[TSet.size()];
        TSet.toArray(arr3);
        System.out.println("Array: " + Arrays.toString(arr3));

        // Direct Array to TreeSet
        Set<Integer> TsetInt1 = new TreeSet<Integer>();
        TsetInt1.addAll(Arrays.asList(new Integer[]{1,2,3,4,5}));
        System.out.println(TsetInt1);


        // SortedSet
        System.out.println("\nJava SortedSet");
        SortedSet<String> SSet = new TreeSet<String>();
        SSet.add("Lorem");
        SSet.add("Ipsum");
        SSet.add("Dolor");
        SSet.add("Sit");
        SSet.add("Amet");
        System.out.println("SortedSet: " + SSet);

        // NavigableSet
        // Methods
        // ceiling()
        // floor()
        // higher()
        // lower()

        System.out.println("\nJava NavigableSet");
        NavigableSet<String> NSet = new TreeSet<String>();
        NSet.add("Lorem");
        NSet.add("Ipsum");
        NSet.add("Dolor");
        NSet.add("Sit");
        NSet.add("Amet");
        System.out.println("NavigableSet: " + NSet);

        // ceiling() - It returns the least element in this set greater than or equal to the given element, or null if there is no such element.
        System.out.println("Ceiling: " + NSet.ceiling("Ipsum"));

        // floor() - It returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
        System.out.println("Floor: " + NSet.floor("Ipsum"));

        // higher() - It returns the least element in this set strictly greater than the given element, or null if there is no such element.
        System.out.println("Higher: " + NSet.higher("Ipsum"));

        // lower() - It returns the greatest element in this set strictly less than the given element, or null if there is no such element.
        System.out.println("Lower: " + NSet.lower("Ipsum"));
    }   
}
