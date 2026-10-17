public class CustomSortString {

    public String customSortString(String order, String s) {
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        // Append characters in the specified order
        for (char ch : order.toCharArray()) {
            while (frequency[ch - 'a'] > 0) {
                result.append(ch);
                frequency[ch - 'a']--;
            }
        }

        // Append characters not present in order
        for (int i = 0; i < 26; i++) {
            while (frequency[i] > 0) {
                result.append((char) ('a' + i));
                frequency[i]--;
            }
        }

        return result.toString();
    }
}

// Time Complexity: O(m + n + 26)
// Space Complexity: O(n + 26)
// LeetCode: 791 - Custom Sort String
