import java.util.*;
// LinkedList methods
// addFirst
// addLast
// removeFirst
// removeLast
// getFirst
// getLast
// get
// pollFirst
// pollLast
// peekFirst
// peekLast
// pop
// push
// offerFirst
// offerLast
class LList{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.addFirst(1);
        list.addLast(4);
        System.out.println(list);
        list.offerFirst(0);
        System.out.println(list);
        // Difference between offer first and add first is offer 
        // first returns false if the element cannot be added
        // add first throws an exception if the element cannot be added
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(list.pollFirst()); // poll prints and removes
        System.out.println(list.pollLast());
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println(list.poll());
        System.out.println(list);
        // Poll and poll first are same
    }
}