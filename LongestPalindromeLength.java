public class LongestPalindromeLength {

    public int longestPalindrome(String s) {
        int[] frequency = new int[128];

        for (char ch : s.toCharArray()) {
            frequency[ch]++;
        }

        int length = 0;
        boolean hasOddFrequency = false;

        for (int count : frequency) {
            length += (count / 2) * 2;

            if (count % 2 == 1) {
                hasOddFrequency = true;
            }
        }

        if (hasOddFrequency) {
            length++;
        }

        return length;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 409 - Longest Palindrome
