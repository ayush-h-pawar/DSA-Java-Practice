public class PartitionArrayMaxSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxValue = 0;

            for (int j = 1; j <= k && i - j >= 0; j++) {
                maxValue = Math.max(maxValue, arr[i - j]);

                int currentSum = dp[i - j] + maxValue * j;
                dp[i] = Math.max(dp[i], currentSum);
            }
        }

        return dp[n];
    }
}

// Time Complexity: O(n * k)
// Space Complexity: O(n)
