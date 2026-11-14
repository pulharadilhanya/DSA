package Submission01;

public class UnboundedArrayStack {

    private int[] arr;
    private int top;

    // Constructor
    public UnboundedArrayStack() {
        arr = new int[4];
        top = -1;
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Expand the array when full
    private void expandArray() {

        int newSize = arr.length * 2;
        int[] newArr = new int[newSize];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Push element to the stack
    public void push(int y) {

        if (top == arr.length - 1) {
            expandArray();
        }

        arr[++top] = y;
    }

    // Pop element from the stack
    public int pop() {

        if (isEmpty()) {
            System.out.println("STACK EMPTY - can't pop");
            return -1;
        }

        return arr[top--];
    }

    // Peek top element
    public int peek() {

        if (isEmpty()) {
            System.out.println("STACK IS EMPTY");
            return -1;
        }

        return arr[top];
    }

    // Return current number of elements
    public int size() {
        return top + 1;
    }

    // Main method
    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.pop();
    }
}
