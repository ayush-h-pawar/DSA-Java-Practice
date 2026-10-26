public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            char ch = abbr.charAt(j);

            if (Character.isDigit(ch)) {
                // Leading zeros are not allowed
                if (ch == '0') {
                    return false;
                }

                int number = 0;

                while (j < abbr.length()
                        && Character.isDigit(abbr.charAt(j))) {
                    number = number * 10 + (abbr.charAt(j) - '0');
                    j++;
                }

                i += number;
            } else {
                if (word.charAt(i) != ch) {
                    return false;
                }

                i++;
                j++;
            }
        }

        return i == word.length() && j == abbr.length();
    }
}

// Time Complexity: O(n + m)
// Space Complexity: O(1)
// LeetCode: 408 - Valid Word Abbreviation
