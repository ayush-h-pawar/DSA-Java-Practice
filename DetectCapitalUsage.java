public class DetectCapitalUsage {

    public boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            }
        }

        // All letters are uppercase
        if (uppercaseCount == word.length()) {
            return true;
        }

        // All letters are lowercase
        if (uppercaseCount == 0) {
            return true;
        }

        // Only the first letter is uppercase
        return uppercaseCount == 1
                && Character.isUpperCase(word.charAt(0));
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 520 - Detect Capital
