import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakBooleanSolver {

    public boolean wordBreak(
            String text,
            List<String> dictionary) {

        Set<String> words =
                new HashSet<>(dictionary);

        boolean[] possible =
                new boolean[text.length() + 1];

        possible[0] = true;

        for (int end = 1;
             end <= text.length();
             end++) {

            for (int start = 0;
                 start < end;
                 start++) {

                if (possible[start]
                        && words.contains(
                                text.substring(
                                        start,
                                        end
                                )
                        )) {

                    possible[end] = true;
                    break;
                }
            }
        }

        return possible[text.length()];
    }

    public static void main(String[] args) {

        WordBreakBooleanSolver solver =
                new WordBreakBooleanSolver();

        String text =
                "leetcode";

        List<String> dictionary =
                List.of(
                        "leet",
                        "code"
                );

        System.out.println(
                solver.wordBreak(
                        text,
                        dictionary
                )
        );
    }
}
