package Submission01;

import java.util.Queue;
import java.util.ArrayDeque;

public class QueueStackPopFriendly<E> {

    private Queue<E> queue1 = new ArrayDeque<>();
    private Queue<E> queue2 = new ArrayDeque<>();

    // Push element
    public void push(E element) {

        queue2.add(element);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Queue<E> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop top element
    public E pop() {

        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return queue1.remove();
    }

    // Peek top element
    public E peek() {
        return queue1.peek();
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Return current number of elements
    public int size() {
        return queue1.size();
    }

    // Main method
    public static void main(String[] args) {

        QueueStackPopFriendly<Integer> stack =
                new QueueStackPopFriendly<>();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Current size: " + stack.size());
    }
}

