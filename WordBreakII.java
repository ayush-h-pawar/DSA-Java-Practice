import java.util.*;

public class WordBreakII {

    static List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();

        return dfs(s, dict, memo);
    }

    static List<String> dfs(String s, Set<String> dict,
                            Map<String, List<String>> memo) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();

        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (String word : dict) {

            if (s.startsWith(word)) {

                List<String> subList =
                        dfs(s.substring(word.length()), dict, memo);

                for (String sub : subList) {

                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}
