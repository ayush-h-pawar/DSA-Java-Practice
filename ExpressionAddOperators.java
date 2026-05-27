import java.util.*;

public class ExpressionAddOperators {

    static List<String> addOperators(
            String num,
            int target) {

        List<String> result =
                new ArrayList<>();

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

    static void backtrack(
            List<String> result,
            String path,
            String num,
            int target,
            int pos,
            long eval,
            long prev) {

        if (pos == num.length()) {

            if (eval == target) {

                result.add(path);
            }

            return;
        }

        for (int i = pos;
             i < num.length();
             i++) {

            if (i != pos &&
                num.charAt(pos) == '0')
                break;

            String currStr =
                    num.substring(pos,
                                  i + 1);

            long curr =
                    Long.parseLong(currStr);

            if (pos == 0) {

                backtrack(
                        result,
                        currStr,
                        num,
                        target,
                        i + 1,
                        curr,
                        curr
                );

            } else {

                backtrack(
                        result,
                        path + "+" + curr,
                        num,
                        target,
                        i + 1,
                        eval + curr,
                        curr
                );

                backtrack(
                        result,
                        path + "-" + curr,
                        num,
                        target,
                        i + 1,
                        eval - curr,
                        -curr
                );

                backtrack(
                        result,
                        path + "*" + curr,
                        num,
                        target,
                        i + 1,
                        eval - prev +
                        prev * curr,
                        prev * curr
                );
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(
                addOperators("123", 6)
        );
    }
}
