public class FindFirstPalindromeWord {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

// Time Complexity: O(n * m)
// Space Complexity: O(1) auxiliary space
// n = number of words, m = maximum word length
