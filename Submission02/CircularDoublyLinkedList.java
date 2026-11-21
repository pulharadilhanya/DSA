
public class CircularDoublyLinkedList {

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
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;

        head = newNode;
    }

    // Insert Last
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            insertFirst(data);
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;
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

        int count = 1;
        Node temp = head;

        while (temp.next != head) {
            count++;
            temp = temp.next;
        }

        if (pos > count + 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == count + 1) {
            insertLast(data);
            return;
        }

        temp = head;

        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Insert After
    public void insertAfter(int key, int data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == key) {
                Node newNode = new Node(data);

                newNode.next = temp.next;
                newNode.prev = temp;

                temp.next.prev = newNode;
                temp.next = newNode;

                return;
            }

            temp = temp.next;

        } while (temp != head);

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

        Node temp = head.next;

        while (temp != head) {
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

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;

        head = head.next;
        head.prev = last;
        last.next = head;
    }

    // Delete Last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node last = head.prev;
        Node secondLast = last.prev;

        secondLast.next = head;
        head.prev = secondLast;
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

        int count = 1;
        Node temp = head;

        while (temp.next != head) {
            count++;
            temp = temp.next;
        }

        if (pos > count) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == count) {
            deleteLast();
            return;
        }

        temp = head;

        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
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

        Node temp = head.next;

        while (temp != head) {
            if (temp.data == key) {

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

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

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;

        } while (temp != head);

        System.out.println("(Back to Head)");
    }

    // Display Backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head.prev;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;

        } while (temp != head.prev);

        System.out.println("(Back to Tail)");
    }

    // Main Method
    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

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
