import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackLink operatorStack = new StackLink();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            try {
                // ตรวจสอบการเปิด-ปิดวงเล็บในสมการ
                checkBrackets(input);

                // แปลงสมการจาก infix เป็น postfix
                String postfix = infixToPostfix(input, operatorStack);
                System.out.println(postfix);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static void checkBrackets(String expression) {
        StackLink bracketStack = new StackLink();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                bracketStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (bracketStack.isEmpty()) {
                    throw new RuntimeException("not found " + matchingOpeningBracket(c));
                }
                char lastBracket = (char) bracketStack.pop();
                if (!bracketsMatch(lastBracket, c)) {
                    throw new RuntimeException("not found " + matchingOpeningBracket(c));
                }
            }
        }

        if (!bracketStack.isEmpty()) {
            throw new RuntimeException("not found " + matchingClosingBracket((char) bracketStack.pop()));
        }
    }

    private static String matchingOpeningBracket(char closingBracket) {
        switch (closingBracket) {
            case ')': return "(";
            case '}': return "{";
            case ']': return "[";
            default: return "";
        }
    }

    private static String matchingClosingBracket(char openingBracket) {
        switch (openingBracket) {
            case '(': return ")";
            case '{': return "}";
            case '[': return "]";
            default: return "";
        }
    }

    private static boolean bracketsMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static String infixToPostfix(String expression, StackLink operatorStack) {
        StringBuilder result = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(' || c == '{' || c == '[') {
                operatorStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                while (!operatorStack.isEmpty() && !isOpeningBracket((char) operatorStack.peek())) {
                    result.append(operatorStack.pop());
                }
                operatorStack.pop(); // pop the opening bracket
            } else {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence((char) operatorStack.peek())) {
                    result.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }

        return result.toString();
    }

    private static boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}