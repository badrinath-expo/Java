import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Ep20_DS {
    public static void stackExample(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack); // [First, Second, Third]
        System.out.println("Top element: " + stack.peek()); // Third
        System.out.println("Popped element: " + stack.pop()); // Third
        System.out.println("Stack after pop: " + stack); // [First, Second]
    }

    public static void queueExample(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        System.out.println(queue); // [A, B, C]
        System.out.println(queue.poll());// A
        System.out.println(queue); // [B,C]
        System.out.println(queue.remove()); // B
        System.out.println(queue); // [C]

    }

    public static void priorityQueue(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("PriorityQueue: " + pq); // Order is not guaranteed in display
        // PriorityQueue: [10, 30, 20]
        while (!pq.isEmpty()) {
            System.out.println("Dequeued: " + pq.poll()); // Sorted order
        }
        /*
         * Dequeued: 10
         * Dequeued: 20
         * Dequeued: 30
         */
    }

// LinkedList<E> – Implements Queue as a doubly linked list (not thread-safe).
// PriorityQueue<E> – Elements are ordered based on priority (not FIFO).
// ArrayDeque<E> – Faster than LinkedList, used as a stack or queue.
// BlockingQueue<E> – Thread-safe queue for multithreading (ArrayBlockingQueue, LinkedBlockingQueue).
}
