import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InfixToPostfix {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the input file name as a command line argument.");
            return;
        }

        String filename = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int expressionCounter = 1;

            while ((line = br.readLine()) != null) {
                // Ignore empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String expr = line.replaceAll("\\s+", "");

                System.out.println("Expression " + expressionCounter + ":");
                System.out.println("Infix exp:" + expr);

                if (isValidInfix(expr)) {
                    System.out.println("Valid");
                    String postfix = convertToPostfix(expr);
                    System.out.println("Postfix exp: " + postfix);
                } else {
                    System.out.println("Not-Valid");
                }

                System.out.println(); // Blank line between expressions
                expressionCounter++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Function to check if the incoming expression is a valid infix expression
    private static boolean isValidInfix(String expr) {
        int state = 0; // 0 = Expecting operand or '(', 1 = Expecting operator or ')'
        int parenCount = 0;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                if (state != 0)
                    return false;
                state = 1; // After an operand, expect an operator or ')'
            } else if (isOperator(c)) {
                if (state != 1)
                    return false;
                state = 0; // After an operator, expect an operand or '('
            } else if (c == '(') {
                if (state != 0)
                    return false;
                parenCount++;
            } else if (c == ')') {
                if (state != 1)
                    return false;
                parenCount--;
                if (parenCount < 0)
                    return false;
            } else {
                return false; // Unknown character
            }
        }

        // Must end expecting an operator or ')', and all parentheses must be closed
        return state == 1 && parenCount == 0;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int getPrecedence(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        if (c == '^')
            return 3;
        return -1;
    }

    private static String convertToPostfix(String expr) {
        StringBuilder postfix = new StringBuilder();
        Stack stack = new Stack();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Pop '('
                }
            } else if (isOperator(c)) {
                // ^ is right-associative, others are left-associative
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (c == '^') {
                        if (getPrecedence(stack.peek()) > getPrecedence(c)) {
                            postfix.append(stack.pop());
                        } else {
                            break;
                        }
                    } else {
                        if (getPrecedence(stack.peek()) >= getPrecedence(c)) {
                            postfix.append(stack.pop());
                        } else {
                            break;
                        }
                    }
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}
