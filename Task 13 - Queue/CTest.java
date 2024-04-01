import java.util.*;

public class CTest {
    public static void main(String[] args) {
        Comparator<Integer> ones_place = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a % 10 - b % 10;
            }
        };
        Comparator<Integer> tens = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (a / 10) % 10 - (b / 10) % 10;
            }
        };
        Comparator<String> arrSt = new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() < b.length()) {
                    return -1;
                }
                return 1;
            }
        };
        // Array List ones
        ArrayList<Integer> ones = new ArrayList<>();
        ones.add(10);
        ones.add(30);
        ones.add(21);
        ones.add(56);
        ones.add(42);
        System.out.println("Array List: " + ones);
        Collections.sort(ones);
        System.out.println("Normal Sorting: " + ones);
        Collections.sort(ones, ones_place);
        System.out.println("Sorting with one's Digit: " + ones);
        // Array List tens
        ArrayList<Integer> tens_list = new ArrayList<>();
        tens_list.add(510);
        tens_list.add(730);
        tens_list.add(121);
        tens_list.add(956);
        tens_list.add(342);
        System.out.println("\nArray List: " + tens_list);
        Collections.sort(tens_list);
        System.out.println("Normal Sorting: " + tens_list);
        Collections.sort(tens_list, tens);
        System.out.println("Sorting with Ten's Digit: " + tens_list);
        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("One");
        strArrayList.add("Two");
        strArrayList.add("Three");
        strArrayList.add("Four");
        strArrayList.add("Seven");
        System.out.println("\nString List: " + strArrayList);
        Collections.sort(strArrayList);
        System.out.println("Normal Sort: " + strArrayList);
        Collections.sort(strArrayList, arrSt);
        System.out.println("Custom Sort: " + strArrayList);
    }
}
