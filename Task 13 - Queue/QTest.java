import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class QTest{
    public static void main(String[] args) {
        // Section 1
        // Queue
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Queue: " + q);
        System.out.println("Removed element: " + q.remove());
        System.out.println("After removal: " + q);
        System.out.println("Peek: " + q.peek());
        q.add(0);
        System.out.println("After add: " + q);
        System.out.println("Size: " + q.size());

        // Section 2
        // Priority Queue
        // How does Ordering in Priority Queue works?
        // The elements are ordered based on
        // their natural ordering, or by a
        // Comparator provided at queue
        // construction time, depending on which
        // constructor is used.
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(3);
        pq.add(0);
        pq.add(5);
        pq.add(4);
        pq.add(3);
        System.out.println("\nPriority Queue: " + pq);
        System.out.println("Removed element: " + pq.remove());
        System.out.println("After removal: " + pq);
        System.out.println("Peek: " + pq.peek());
        while(!pq.isEmpty()){
            System.out.println("Removed element: " + pq.remove());
        }

        // Section 3
        // Dequeue
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);
        dq.add(4);
        dq.add(5);
        System.out.println("\nDeque: " + dq);
        System.out.println("Removed element: " + dq.remove());
        System.out.println("After removal: " + dq);
        System.out.println("Peek: " + dq.peek());
        dq.add(0);
        System.out.println("After add: " + dq);
        System.out.println("Size: " + dq.size());

        // Section 4
        // Difference between Queue and Deque

        // Queue is a collection designed for holding elements prior to processing.
        // Besides basic Collection operations, queues provide additional insertion,
        // extraction, and inspection operations. Each of these methods exists in
        // two forms: one throws an exception if the operation fails, the other
        // returns a special value (either null or false, depending on the operation).
        // The latter form of the insert operation is designed specifically for use
        // with capacity-restricted Queue implementations; in most implementations,
        // insert operations cannot fail.

        // Deque is a linear collection that supports element insertion and removal
        // at both ends. The name deque is short for "double ended queue" and is
        // usually pronounced "deck". Most Deque implementations place no fixed
        // limits on the number of elements they may contain, but this interface
        // supports capacity-restricted deques as well as those with no fixed size limit.
        // Deques are designed to be used in concurrent applications. This interface
        // supports a set of operations that enable a deque to be treated as a stack.
        // When a deque is used as a stack, elements are pushed and popped from the
        // beginning of the deque. Stack methods are precisely equivalent to Deque methods.
    
        // Difference between Deque and ArrayDeque

        // ArrayDeque is a resizable-array implementation of the Deque interface.
        // Array deques have no capacity restrictions; they grow as necessary to
        // support usage. They are not thread-safe; in the absence of external
        // synchronization, they do not support concurrent access by multiple threads.
        // Null elements are prohibited. This class is likely to be faster than
        // Stack when used as a stack, and faster than LinkedList when used as a queue.

        // ArrayDeque is not thread-safe, so in a concurrent environment, you should
        // use ConcurrentLinkedDeque or LinkedBlockingDeque.
        // ArrayDeque is faster than LinkedList in the case of adding and removing
        // elements, but it is slower than the LinkedList in the case of searching
        // elements. ArrayDeque is the best choice if you want to use it as a stack
        // or a queue. 

        // Section 5
        // ArrayDeque
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(1);
        ad.add(2);
        ad.add(3);
        ad.add(4);
        ad.add(5);
        System.out.println("\nArrayDeque: " + ad);
        System.out.println("Removed element: " + ad.remove());
        System.out.println("After removal: " + ad);
        System.out.println("Peek: " + ad.peek());
        ad.add(0);
        System.out.println("After add: " + ad);
        System.out.println("Size: " + ad.size());
    }
}
