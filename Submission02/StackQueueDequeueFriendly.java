
import java.util.Stack;

public class StackQueueDequeueFriendly {

    Stack<Integer> main_stack = new Stack<>();
    Stack<Integer> aux_stack = new Stack<>();

    // Enqueue
    public void enqueue(int data) {

        while (!main_stack.isEmpty()) {
            aux_stack.push(main_stack.pop());
        }

        main_stack.push(data);

        while (!aux_stack.isEmpty()) {
            main_stack.push(aux_stack.pop());
        }
    }

    // Dequeue
    public int dequeue() {

        if (main_stack.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return main_stack.pop();
    }

    // Peek
    public int peek() {

        if (main_stack.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return main_stack.peek();
    }

    // isEmpty
    public boolean isEmpty() {
        return main_stack.isEmpty();
    }

    // Display
    public void display() {

        if (main_stack.isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println(main_stack);
    }

    // Main Method
    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Queue:");
        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println("After Dequeue:");
        queue.display();
    }
}
