public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(
            String text) {

        int n = text.length();

        int[][] dp =
                new int[n][n];

        for (int index = 0;
             index < n;
             index++) {

            dp[index][index] = 1;
        }

        for (int left = n - 2;
             left >= 0;
             left--) {

            for (int right = left + 1;
                 right < n;
                 right++) {

                if (text.charAt(left)
                        == text.charAt(right)) {

                    dp[left][right] =
                            dp[left + 1][right - 1]
                                    + 2;

                } else {

                    dp[left][right] =
                            Math.max(
                                    dp[left + 1][right],
                                    dp[left][right - 1]
                            );
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        LongestPalindromicSubsequence solver =
                new LongestPalindromicSubsequence();

        String text =
                "bbbab";

        System.out.println(
                solver.longestPalindromeSubseq(
                        text
                )
        );
    }
}
