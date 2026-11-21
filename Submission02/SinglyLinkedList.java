
public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    // Insert First
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert Last
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Insert At Position
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

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Insert After
    public void insertAfter(int key, int data) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key Not Found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Insert Before
    public void insertBefore(int key, int data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.data == key) {
            insertFirst(data);
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Key Not Found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete First
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        head = head.next;
    }

    // Delete Last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // Delete At Position
    public void deleteAtPosition(int pos) {
        if (head == null || pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node current = head;

        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Invalid Position");
            return;
        }

        current.next = current.next.next;
    }

    // Delete By Value
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.data == key) {
            deleteFirst();
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value Not Found");
            return;
        }

        current.next = current.next.next;
    }

    // Display
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Main Method
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

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
    }
}
