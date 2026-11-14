package Submission01;

import java.util.Deque;
import java.util.ArrayDeque;

public class StackQueueEnqueueFriendly<E> {

    private Deque<E> stack1 = new ArrayDeque<>();
    private Deque<E> stack2 = new ArrayDeque<>();

    // Enqueue element
    public void enqueue(E element) {
        stack1.push(element);
    }

    // Dequeue element
    public E dequeue() {

        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        E oldest = stack1.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return oldest;
    }

    // Peek front element
    public E peek() {

        if (stack1.isEmpty()) {
            return null;
        }

        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        E oldest = stack1.pop();
        stack2.push(oldest);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return oldest;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    // Return current number of elements
    public int size() {
        return stack1.size();
    }

    // Main method
    public static void main(String[] args) {

        StackQueueEnqueueFriendly<Integer> queue =
                new StackQueueEnqueueFriendly<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Current size: " + queue.size());
    }
}
