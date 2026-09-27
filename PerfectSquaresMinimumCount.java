public class PerfectSquaresMinimumCount {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        // Maximum possible answer is n (1 + 1 + ... + 1)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int square = 1; square * square <= i; square++) {
                dp[i] = Math.min(
                        dp[i],
                        dp[i - square * square] + 1
                );
            }
        }

        return dp[n];
    }
}

// Time Complexity: O(n * sqrt(n))
// Space Complexity: O(n)
// LeetCode: 279 - Perfect Squares
