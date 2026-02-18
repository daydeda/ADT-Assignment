public class SingleLinkedList {
    private Node head;
    private int size;

    // Constructor
    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Insert Last
    public void insertLast(CovidVaccine data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Delete at random index (index is passed as argument)
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index: " + index);
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
        System.out.println("Deleted node at index " + index);
    }

    // Delete All
    public void deleteAll() {
        head = null;
        size = 0;
        System.out.println("All nodes deleted.");
    }

    // Get Size
    public int getSize() {
        return size;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // Traversal
    public void traversal() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println("Index " + index + ": " + current.data);
            current = current.next;
            index++;
        }
    }
}
