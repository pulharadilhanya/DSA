
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

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
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

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Insert After
    public void insertAfter(int key, int data) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == key) {

                Node newNode = new Node(data);

                newNode.next = temp.next;
                temp.next = newNode;

                return;
            }

            temp = temp.next;
        }

        System.out.println("Key Not Found");
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

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.data == key) {

                Node newNode = new Node(data);

                newNode.next = temp.next;
                temp.next = newNode;

                return;
            }

            temp = temp.next;
        }

        System.out.println("Key Not Found");
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

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    // Delete At Position (1-based)
    public void deleteAtPosition(int pos) {

        if (head == null || pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid Position");
            return;
        }

        temp.next = temp.next.next;
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

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.data == key) {
                temp.next = temp.next.next;
                return;
            }

            temp = temp.next;
        }

        System.out.println("Value Not Found");
    }

    // Display
    public void display() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
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
