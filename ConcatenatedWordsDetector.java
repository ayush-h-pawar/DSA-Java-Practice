import java.util.*;

public class ConcatenatedWordsDetector {

    static List<String>
    findAllConcatenatedWords(
            String[] words) {

        Set<String> dict =
                new HashSet<>(
                        Arrays.asList(words)
                );

        List<String> result =
                new ArrayList<>();

        for (String word : words) {

            if (canForm(
                    word,
                    dict
            )) {

                result.add(word);
            }
        }

        return result;
    }

    static boolean canForm(
            String word,
            Set<String> dict) {

        if (word.isEmpty())
            return false;

        dict.remove(word);

        boolean[] dp =
                new boolean[
                        word.length() + 1
                ];

        dp[0] = true;

        for (int i = 1;
             i <= word.length();
             i++) {

            for (int j = 0;
                 j < i;
                 j++) {

                if (dp[j] &&
                    dict.contains(
                            word.substring(
                                    j,
                                    i
                            )
                    )) {

                    dp[i] = true;
                    break;
                }
            }
        }

        dict.add(word);

        return dp[word.length()];
    }
}
