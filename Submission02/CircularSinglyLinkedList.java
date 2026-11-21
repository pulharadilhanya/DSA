
public class CircularSinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;
    Node tail;

    // Insert First
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // Insert Last
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;
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

        if (head == null) {
            System.out.println("Invalid Position");
            return;
        }

        Node current = head;
        int count = 1;

        while (count < pos - 1 && current != tail) {
            current = current.next;
            count++;
        }

        if (count != pos - 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (current == tail) {
            insertLast(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Insert After Key
    public void insertAfter(int key, int data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        do {
            if (current.data == key) {
                Node newNode = new Node(data);

                newNode.next = current.next;
                current.next = newNode;

                if (current == tail) {
                    tail = newNode;
                }

                tail.next = head;
                return;
            }

            current = current.next;

        } while (current != head);

        System.out.println("Key Not Found");
    }

    // Insert Before Key
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

        while (current.next != head && current.next.data != key) {
            current = current.next;
        }

        if (current.next == head) {
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

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    // Delete Last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;

        while (current.next != tail) {
            current = current.next;
        }

        tail = current;
        tail.next = head;
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

        Node current = head;
        int count = 1;

        while (count < pos - 1 && current != tail) {
            current = current.next;
            count++;
        }

        if (count != pos - 1 || current == tail) {
            System.out.println("Invalid Position");
            return;
        }

        if (current.next == tail) {
            deleteLast();
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

        while (current.next != head && current.next.data != key) {
            current = current.next;
        }

        if (current.next == head) {
            System.out.println("Value Not Found");
            return;
        }

        if (current.next == tail) {
            deleteLast();
            return;
        }

        current.next = current.next.next;
    }

    // Display
    public void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(Back to Head)");
    }

    // Main Method
    public static void main(String[] args) {

        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

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
