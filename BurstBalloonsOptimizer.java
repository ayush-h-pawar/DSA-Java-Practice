public class BurstBalloonsOptimizer {

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int length = 1; length <= n; length++) {

            for (int left = 1;
                 left <= n - length + 1;
                 left++) {

                int right = left + length - 1;

                for (int last = left;
                     last <= right;
                     last++) {

                    int coins =
                            balloons[left - 1]
                                    * balloons[last]
                                    * balloons[right + 1];

                    coins += dp[left][last - 1];
                    coins += dp[last + 1][right];

                    dp[left][right] =
                            Math.max(
                                    dp[left][right],
                                    coins
                            );
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {

        BurstBalloonsOptimizer solver =
                new BurstBalloonsOptimizer();

        int[] balloons = {3, 1, 5, 8};

        System.out.println(
                solver.maxCoins(balloons)
        );
    }
}
