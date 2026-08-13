import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigitsOptimizer {

    public String removeKdigits(
            String number,
            int k) {

        Deque<Character> stack =
                new ArrayDeque<>();

        for (char digit :
                number.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        while (k > 0) {

            stack.pop();
            k--;
        }

        StringBuilder result =
                new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }

        int index = 0;

        while (index < result.length()
                && result.charAt(index) == '0') {

            index++;
        }

        String answer =
                result.substring(index);

        return answer.isEmpty()
                ? "0"
                : answer;
    }

    public static void main(String[] args) {

        RemoveKDigitsOptimizer solver =
                new RemoveKDigitsOptimizer();

        System.out.println(
                solver.removeKdigits(
                        "1432219",
                        3
                )
        );

        System.out.println(
                solver.removeKdigits(
                        "10200",
                        1
                )
        );
    }
}
