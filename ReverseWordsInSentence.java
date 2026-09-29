public class ReverseWordsInSentence {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            int end = i;

            // Find beginning of word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            if (result.length() > 0) {
                result.append(' ');
            }

            result.append(s, i + 1, end + 1);
        }

        return result.toString();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 151 - Reverse Words in a String
