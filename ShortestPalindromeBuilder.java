public class ShortestPalindromeBuilder {

    public String shortestPalindrome(String s) {

        String reversed =
                new StringBuilder(s)
                        .reverse()
                        .toString();

        String combined =
                s + "#" + reversed;

        int[] lps =
                buildLPS(combined);

        int longestPrefixPalindrome =
                lps[combined.length() - 1];

        String suffix =
                s.substring(
                        longestPrefixPalindrome
                );

        return new StringBuilder(suffix)
                .reverse()
                .append(s)
                .toString();
    }

    private int[] buildLPS(String pattern) {

        int[] lps =
                new int[pattern.length()];

        int length = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i)
                    == pattern.charAt(length)) {

                length++;
                lps[i] = length;
                i++;

            } else {

                if (length != 0) {

                    length =
                            lps[length - 1];

                } else {

                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {

        ShortestPalindromeBuilder solver =
                new ShortestPalindromeBuilder();

        System.out.println(
                solver.shortestPalindrome("aacecaaa")
        );

        System.out.println(
                solver.shortestPalindrome("abcd")
        );
    }
}
