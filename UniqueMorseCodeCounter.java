import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeCounter {

    private static final String[] MORSE = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();

        for (String word : words) {
            StringBuilder code = new StringBuilder();

            for (char ch : word.toCharArray()) {
                code.append(MORSE[ch - 'a']);
            }

            transformations.add(code.toString());
        }

        return transformations.size();
    }
}

// Time Complexity: O(total characters across all words)
// Space Complexity: O(total encoded characters)
// LeetCode: 804 - Unique Morse Code Words
