public class RegularExpressionMatcher {

    public boolean isMatch(
            String text,
            String pattern) {

        int m = text.length();
        int n = pattern.length();

        boolean[][] dp =
                new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 2; j <= n; j++) {

            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char p = pattern.charAt(j - 1);

                if (p == '.'
                        || p == text.charAt(i - 1)) {

                    dp[i][j] =
                            dp[i - 1][j - 1];

                } else if (p == '*') {

                    dp[i][j] =
                            dp[i][j - 2];

                    char previous =
                            pattern.charAt(j - 2);

                    if (previous == '.'
                            || previous
                            == text.charAt(i - 1)) {

                        dp[i][j] |=
                                dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        RegularExpressionMatcher matcher =
                new RegularExpressionMatcher();

        System.out.println(
                matcher.isMatch(
                        "aab",
                        "c*a*b"
                )
        );
    }
}
