import java.util.Stack;

public class BasicCalculatorIII {

    public int calculate(String expression) {

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int n = expression.length();
        int index = 0;

        while (index < n) {

            char current = expression.charAt(index);

            if (current == ' ') {
                index++;
                continue;
            }

            if (Character.isDigit(current)) {

                int number = 0;

                while (index < n &&
                        Character.isDigit(expression.charAt(index))) {

                    number = number * 10
                            + (expression.charAt(index) - '0');

                    index++;
                }

                numbers.push(number);
                continue;
            }

            if (current == '(') {

                operators.push(current);

            } else if (current == ')') {

                while (operators.peek() != '(') {
                    evaluate(numbers, operators);
                }

                operators.pop();

            } else {

                while (!operators.isEmpty()
                        && precedence(operators.peek())
                        >= precedence(current)) {

                    evaluate(numbers, operators);
                }

                operators.push(current);
            }

            index++;
        }

        while (!operators.isEmpty()) {
            evaluate(numbers, operators);
        }

        return numbers.pop();
    }

    private void evaluate(
            Stack<Integer> numbers,
            Stack<Character> operators) {

        int second = numbers.pop();
        int first = numbers.pop();

        char operator = operators.pop();

        switch (operator) {

            case '+':
                numbers.push(first + second);
                break;

            case '-':
                numbers.push(first - second);
                break;

            case '*':
                numbers.push(first * second);
                break;

            case '/':
                numbers.push(first / second);
                break;
        }
    }

    private int precedence(char operator) {

        if (operator == '+' || operator == '-') {
            return 1;
        }

        if (operator == '*' || operator == '/') {
            return 2;
        }

        return 0;
    }

    public static void main(String[] args) {

        BasicCalculatorIII calculator =
                new BasicCalculatorIII();

        System.out.println(
                calculator.calculate("2*(5+5*2)/3+(6/2+8)")
        );

        System.out.println(
                calculator.calculate("(2+6*3+5-(3*14/7+2)*5)+3")
        );
    }
}
