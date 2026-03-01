import java.util.Stack;

public class ParenthesesValidator {

    static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
