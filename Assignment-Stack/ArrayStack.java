public class ArrayStack {
    // 1. Attributes/Properties (private array data structure)
    private int maxSize;
    private long[] stackArray; // Using 'long' to accommodate large ID numbers
    private int top;

    // 2. Constructor
    public ArrayStack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1; // -1 indicates the stack is empty
    }

    // 3. Methods: push(), pop(), peek(), isEmpty(), isFull()

    // Add item to the top of the stack
    public void push(long j) {
        if (isFull()) {
            System.out.println("Stack is full! Cannot push " + j);
        } else {
            stackArray[++top] = j;
        }
    }

    // Remove item from the top of the stack
    public long pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1; // Return a default indicator for empty
        } else {
            return stackArray[top--];
        }
    }

    // View the item at the top without removing it
    public long peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    
    // Helper method to help with the final print requirement
    public int getCount() {
        return top + 1;
    }
}