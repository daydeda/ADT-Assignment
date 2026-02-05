public class Main {

    public static void main(String[] args) {
        // Initialize stack with a size large enough for an ID
        ArrayStack myStack = new ArrayStack(10);

        System.out.println("--- Pushing Student ID to Stack ---");
        // Example Student ID: 682115036
        myStack.push(6);
        myStack.push(8);
        myStack.push(2);
        myStack.push(1);
        myStack.push(1);
        myStack.push(5);
        myStack.push(0);
        myStack.push(3);
        myStack.push(6);

        System.out.println("Stack populated.\n");

        System.out.println("--- Executing Required Methods ---");

        // 1. Peek()
        long peekVal = myStack.peek();
        System.out.println("Peek(): " + peekVal);

        // 2. Pop()
        long pop1 = myStack.pop();
        System.out.println("Pop(): " + pop1);

        // 3. Pop()
        long pop2 = myStack.pop();
        System.out.println("Pop(): " + pop2);

        // 4. Pop()
        long pop3 = myStack.pop();
        System.out.println("Pop(): " + pop3);

        System.out.println("\n--- Final Status ---");

        // 5. Print out how many elements left in your stack
        System.out.println("Elements left in stack: " + myStack.getCount());
    }
}
