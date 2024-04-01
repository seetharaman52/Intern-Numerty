import java.util.*;
// Methods of List interface
// add()
// addAll()
// clear()
// equals()
// get()
// indexOf()
// isEmpty()
// remove(index)
// removeAll()
// size()
// toArray()
// contains()
// containsAll()
// retainAll()
// sort()
// replaceAll()
// removeIf()
// subList()
// listIterator()
// iterator()
// forEach()
class JList{
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(0, 4); // add 4 at index 0
        System.out.println(list1);
        //list1.clear(); // remove all elements
        list2.add(0);
        list2.addAll(list1); // add all elements of list1 to list2
        System.out.println(list2);
        System.out.println(list1.equals(list2)); // check if both lists are equal
        System.out.println(list1.get(0)); // get element at index 0
        System.out.println(list1.indexOf(0)); // get index of element 2
        System.out.println(list1.isEmpty()); // check if list is empty
        list1.remove(3); // remove element at index 3
        System.out.println(list1);
        System.out.println(list1.size()); // get size of list
        // Print using iterator
        Iterator<Integer> it = list1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // Difference between iterator and listIterator
        
        // iterator
        // iterator can traverse in only one direction
        // iterator cannot modify the list
        
        // listIterator
        // listIterator can traverse in both directions
        // listIterator can modify the list

        // listIterator normal print
        ListIterator<Integer> lit1 = list1.listIterator();
        while(lit1.hasNext()){
            System.out.print(lit1.next() + " ");
        }
        System.out.println();

        // List iterator reverse print
        ListIterator<Integer> lit = list1.listIterator(list1.size());
        while(lit.hasPrevious()){
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        // for each
        list2.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        list2.forEach(
            System.out::println
        );
    }
}