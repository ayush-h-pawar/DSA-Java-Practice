import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsWindow {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] frequency = new int[26];

        for (char c : p.toCharArray()) {
            frequency[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int required = p.length();

        while (right < s.length()) {
            char current = s.charAt(right);

            if (frequency[current - 'a'] > 0) {
                required--;
            }

            frequency[current - 'a']--;
            right++;

            if (right - left > p.length()) {
                char removed = s.charAt(left);

                if (frequency[removed - 'a'] >= 0) {
                    required++;
                }

                frequency[removed - 'a']++;
                left++;
            }

            if (required == 0) {
                result.add(left);
            }
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 438 - Find All Anagrams in a String
