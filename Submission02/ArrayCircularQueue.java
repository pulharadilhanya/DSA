
public class ArrayCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    // Constructor
    ArrayCircularQueue(int capacity) {

        this.capacity = capacity;
        queue = new int[capacity];

        front = -1;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void enqueue(int data) {

        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    // Dequeue
    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int data = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;

        return data;
    }

    // Peek
    public int peek() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return queue[front];
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // isFull
    public boolean isFull() {
        return size == capacity;
    }

    // Display
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {

        ArrayCircularQueue queue =
                new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());

        queue.display();

        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println("After Adding More Elements:");
        queue.display();
    }
}
