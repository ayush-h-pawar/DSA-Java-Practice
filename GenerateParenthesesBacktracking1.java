import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesBacktracking1 {

    public List<String> generateParenthesis(
            int pairs) {

        List<String> result =
                new ArrayList<>();

        build(
                pairs,
                0,
                0,
                new StringBuilder(),
                result
        );

        return result;
    }

    private void build(
            int pairs,
            int open,
            int close,
            StringBuilder current,
            List<String> result) {

        if (current.length()
                == pairs * 2) {

            result.add(
                    current.toString()
            );

            return;
        }

        if (open < pairs) {

            current.append('(');

            build(
                    pairs,
                    open + 1,
                    close,
                    current,
                    result
            );

            current.deleteCharAt(
                    current.length() - 1
            );
        }

        if (close < open) {

            current.append(')');

            build(
                    pairs,
                    open,
                    close + 1,
                    current,
                    result
            );

            current.deleteCharAt(
                    current.length() - 1
            );
        }
    }

    public static void main(String[] args) {

        GenerateParenthesesBacktracking solver =
                new GenerateParenthesesBacktracking();

        System.out.println(
                solver.generateParenthesis(3)
        );
    }
}
