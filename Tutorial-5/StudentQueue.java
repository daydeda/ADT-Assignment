
import java.util.Scanner;

public class StudentQueue {
    private String[] queue;
    private int first;
    private int rear;
    private int length;
    private int capacity;

    public StudentQueue(int size) {
        this.capacity = size;
        this.queue = new String[size];
        this.first = 0;
        this.rear = 0;
        this.length = 0;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isFull() {
        return this.rear == this.capacity;
    }

    public void enqueue(String item) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        queue[rear] = item;
        rear++;
        length++;

        System.out.println("Enqueue " + item);
        printStatus();
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        String item = queue[first];
        queue[first] = null;
        first++;
        length--;

        System.out.println("Dequeue " + item);
        printStatus();
        return item;
    }

    private void printStatus() {
        System.out.print("[");
        for (int i = first; i < capacity; i++) {
            System.out.print(queue[i]);
            if (i < capacity - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] [first = " + first + ", rear = " + rear + ", length = " + length + "]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentQueue q = new StudentQueue(5);

        System.out.println("Please enter student name (enter 'quit' for exit the program):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            q.enqueue(input);
        }
        q.dequeue();

        scanner.close();
    }
}
