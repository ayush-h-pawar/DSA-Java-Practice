import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorExpression {

    public int calculate(String expression) {

        Deque<Integer> stack =
                new ArrayDeque<>();

        int number = 0;
        int sign = 1;
        int result = 0;

        for (int index = 0;
             index < expression.length();
             index++) {

            char current =
                    expression.charAt(index);

            if (Character.isDigit(current)) {

                number =
                        number * 10
                        + (current - '0');

            } else if (current == '+') {

                result += sign * number;

                number = 0;
                sign = 1;

            } else if (current == '-') {

                result += sign * number;

                number = 0;
                sign = -1;

            } else if (current == '(') {

                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;

            } else if (current == ')') {

                result += sign * number;

                number = 0;

                int previousSign =
                        stack.pop();

                int previousResult =
                        stack.pop();

                result =
                        previousResult
                        + previousSign * result;
            }
        }

        result += sign * number;

        return result;
    }

    public static void main(String[] args) {

        BasicCalculatorExpression solver =
                new BasicCalculatorExpression();

        String expression =
                "(1+(4+5+2)-3)+(6+8)";

        System.out.println(
                solver.calculate(expression)
        );
    }
}
