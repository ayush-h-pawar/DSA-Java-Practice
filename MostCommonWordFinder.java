import java.util.*;

public class MostCommonWordFinder {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();

        for (String word : banned) {
            bannedWords.add(word.toLowerCase());
        }

        Map<String, Integer> frequency = new HashMap<>();

        String[] words = paragraph.toLowerCase().split("[^a-z]+");

        String result = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedWords.contains(word)) {
                continue;
            }

            int count = frequency.getOrDefault(word, 0) + 1;
            frequency.put(word, count);

            if (count > maxCount) {
                maxCount = count;
                result = word;
            }
        }

        return result;
    }
}

// Time Complexity: O(n + b)
// Space Complexity: O(n + b)
