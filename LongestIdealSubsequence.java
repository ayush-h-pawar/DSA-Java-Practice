public class LongestIdealSubsequence {

    // The input contains lowercase English letters and k is in [0, 25].
    public int longestIdealString(String s, int k) {
        int[] bestEndingAt = new int[26];
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i) - 'a';
            int first = Math.max(0, letter - k);
            int last = Math.min(25, letter + k);
            int bestPrevious = 0;

            for (int previous = first; previous <= last; previous++) {
                bestPrevious = Math.max(bestPrevious, bestEndingAt[previous]);
            }

            bestEndingAt[letter] = bestPrevious + 1;
            longest = Math.max(longest, bestEndingAt[letter]);
        }

        return longest;
    }
}

// Time Complexity: O(n * min(26, 2k + 1))
// Space Complexity: O(1)
