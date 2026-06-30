import java.util.*;

public class WordBreakIIComposer {

    public List<String> wordBreak(
            String s,
            List<String> wordDict) {

        Set<String> dictionary =
                new HashSet<>(wordDict);

        Map<Integer, List<String>> memo =
                new HashMap<>();

        return dfs(
                s,
                0,
                dictionary,
                memo
        );
    }

    private List<String> dfs(
            String s,
            int start,
            Set<String> dictionary,
            Map<Integer, List<String>> memo) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result =
                new ArrayList<>();

        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1;
             end <= s.length();
             end++) {

            String word =
                    s.substring(start, end);

            if (!dictionary.contains(word)) {
                continue;
            }

            List<String> suffixes =
                    dfs(
                            s,
                            end,
                            dictionary,
                            memo
                    );

            for (String suffix : suffixes) {

                if (suffix.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(
                            word + " " + suffix
                    );
                }
            }
        }

        memo.put(start, result);

        return result;
    }

    public static void main(String[] args) {

        WordBreakIIComposer solver =
                new WordBreakIIComposer();

        List<String> dictionary =
                Arrays.asList(
                        "cat",
                        "cats",
                        "and",
                        "sand",
                        "dog"
                );

        System.out.println(
                solver.wordBreak(
                        "catsanddog",
                        dictionary
                )
        );
    }
}
