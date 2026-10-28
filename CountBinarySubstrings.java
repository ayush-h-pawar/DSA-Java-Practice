public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int previousGroup = 0;
        int currentGroup = 1;
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroup++;
            } else {
                count += Math.min(previousGroup, currentGroup);
                previousGroup = currentGroup;
                currentGroup = 1;
            }
        }

        count += Math.min(previousGroup, currentGroup);

        return count;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 696 - Count Binary Substrings
