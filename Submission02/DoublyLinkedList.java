
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

    // Insert First
    public void insertFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
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
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
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
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // Insert After
    public void insertAfter(int key, int data) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == key) {

                Node newNode = new Node(data);

                newNode.next = temp.next;
                newNode.prev = temp;

                if (temp.next != null) {
                    temp.next.prev = newNode;
                }

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

        while (temp != null) {

            if (temp.data == key) {

                Node newNode = new Node(data);

                newNode.next = temp;
                newNode.prev = temp.prev;

                temp.prev.next = newNode;
                temp.prev = newNode;

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

        if (head != null) {
            head.prev = null;
        }
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

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
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

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        temp.prev.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
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

        while (temp != null) {

            if (temp.data == key) {

                temp.prev.next = temp.next;

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }

                return;
            }

            temp = temp.next;
        }

        System.out.println("Value Not Found");
    }

    // Display Forward
    public void display() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Display Backward
    public void displayBackward() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
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
