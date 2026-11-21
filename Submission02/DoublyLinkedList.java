
public class DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    Node head;
    Node tail;

    // Insert First
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert Last
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert At Position (1-based)
    public void insertAtPosition(int data, int pos) {
        if (pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            insertFirst(data);
            return;
        }

        Node current = head;

        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (current == tail) {
            insertLast(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = current.next;
        newNode.prev = current;

        current.next.prev = newNode;
        current.next = newNode;
    }

    // Insert After Key
    public void insertAfter(int key, int data) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key Not Found");
            return;
        }

        if (current == tail) {
            insertLast(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.next = current.next;
        newNode.prev = current;

        current.next.prev = newNode;
        current.next = newNode;
    }

    // Insert Before Key
    public void insertBefore(int key, int data) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key Not Found");
            return;
        }

        if (current == head) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;
    }

    // Delete First
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // Delete Last
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // Delete At Position (1-based)
    public void deleteAtPosition(int pos) {
        if (pos < 1 || head == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node current = head;

        for (int i = 1; i < pos && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid Position");
            return;
        }

        if (current == tail) {
            deleteLast();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    // Delete By Value
    public void deleteByValue(int key) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value Not Found");
            return;
        }

        if (current == head) {
            deleteFirst();
            return;
        }

        if (current == tail) {
            deleteLast();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    // Display Forward
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Display Backward
    public void displayBackward() {
        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    // Main Method
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertLast(50);

        System.out.println("Original List:");
        list.display();

        list.insertAtPosition(30, 3);
        System.out.println("After Insert At Position:");
        list.display();

        list.insertAfter(30, 35);
        System.out.println("After Insert After:");
        list.display();

        list.insertBefore(40, 38);
        System.out.println("After Insert Before:");
        list.display();

        list.deleteFirst();
        System.out.println("After Delete First:");
        list.display();

        list.deleteLast();
        System.out.println("After Delete Last:");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("After Delete At Position:");
        list.display();

        list.deleteByValue(35);
        System.out.println("After Delete By Value:");
        list.display();

        System.out.println("Display Backward:");
        list.displayBackward();
    }
}
