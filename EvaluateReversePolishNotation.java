import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Deque<Integer> stack =
                new ArrayDeque<>();

        for (String token : tokens) {

            if (token.equals("+")
                    || token.equals("-")
                    || token.equals("*")
                    || token.equals("/")) {

                int second = stack.pop();
                int first = stack.pop();

                switch (token) {

                    case "+":
                        stack.push(first + second);
                        break;

                    case "-":
                        stack.push(first - second);
                        break;

                    case "*":
                        stack.push(first * second);
                        break;

                    case "/":
                        stack.push(first / second);
                        break;
                }

            } else {

                stack.push(
                        Integer.parseInt(token)
                );
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {

        EvaluateReversePolishNotation solver =
                new EvaluateReversePolishNotation();

        String[] tokens = {
                "2",
                "1",
                "+",
                "3",
                "*"
        };

        System.out.println(
                solver.evalRPN(tokens)
        );
    }
}
