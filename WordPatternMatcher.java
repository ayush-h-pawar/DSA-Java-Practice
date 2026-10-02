import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternMatcher {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char character = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(character)) {
                if (!charToWord.get(character).equals(word)) {
                    return false;
                }
            } else {
                if (usedWords.contains(word)) {
                    return false;
                }

                charToWord.put(character, word);
                usedWords.add(word);
            }
        }

        return true;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 290 - Word Pattern
