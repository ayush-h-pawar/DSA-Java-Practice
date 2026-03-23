import java.util.Stack;

public class RemoveKDigits {

    static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // Remove remaining digits
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k)); // Output: 1219
    }
}
