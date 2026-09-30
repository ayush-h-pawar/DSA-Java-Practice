public class FirstUniqueCharacterFinder {

    public int firstUniqChar(String s) {
        int[] frequency = new int[26];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 387 - First Unique Character in a String
