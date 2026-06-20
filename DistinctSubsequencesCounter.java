public class DistinctSubsequencesCounter {

    public int numDistinct(
            String source,
            String target) {

        int m = source.length();
        int n = target.length();

        long[][] dp =
                new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (source.charAt(i - 1)
                        == target.charAt(j - 1)) {

                    dp[i][j] =
                            dp[i - 1][j - 1]
                                    + dp[i - 1][j];

                } else {

                    dp[i][j] =
                            dp[i - 1][j];
                }
            }
        }

        return (int) dp[m][n];
    }

    public static void main(String[] args) {

        DistinctSubsequencesCounter solver =
                new DistinctSubsequencesCounter();

        System.out.println(
                solver.numDistinct(
                        "rabbbit",
                        "rabbit"
                )
        );
    }
}
