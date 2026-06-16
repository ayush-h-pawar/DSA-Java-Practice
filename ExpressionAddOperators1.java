import java.util.*;

public class ExpressionAddOperators1 {

    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        if (num == null || num.length() == 0)
            return result;

        backtrack(
                result,
                "",
                num,
                target,
                0,
                0,
                0
        );

        return result;
    }

    private void backtrack(
            List<String> result,
            String expression,
            String num,
            int target,
            int index,
            long value,
            long previous) {

        if (index == num.length()) {

            if (value == target) {
                result.add(expression);
            }

            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0')
                break;

            String currentString =
                    num.substring(index, i + 1);

            long current =
                    Long.parseLong(currentString);

            if (index == 0) {

                backtrack(
                        result,
                        currentString,
                        num,
                        target,
                        i + 1,
                        current,
                        current
                );

            } else {

                backtrack(
                        result,
                        expression + "+" + currentString,
                        num,
                        target,
                        i + 1,
                        value + current,
                        current
                );

                backtrack(
                        result,
                        expression + "-" + currentString,
                        num,
                        target,
                        i + 1,
                        value - current,
                        -current
                );

                backtrack(
                        result,
                        expression + "*" + currentString,
                        num,
                        target,
                        i + 1,
                        value - previous + previous * current,
                        previous * current
                );
            }
        }
    }

    public static void main(String[] args) {

        ExpressionAddOperators solver =
                new ExpressionAddOperators();

        System.out.println(
                solver.addOperators("123", 6)
        );
    }
}
