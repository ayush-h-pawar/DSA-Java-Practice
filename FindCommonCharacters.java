import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] common = new int[26];

        for (int i = 0; i < 26; i++) {
            common[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            int[] frequency = new int[26];

            for (char ch : word.toCharArray()) {
                frequency[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                common[i] = Math.min(common[i], frequency[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                common[i]--;
            }
        }

        return result;
    }
}

// Time Complexity: O(total characters across all words + 26 * words.length)
// Space Complexity: O(1) auxiliary space, excluding the result
// LeetCode: 1002 - Find Common Characters
