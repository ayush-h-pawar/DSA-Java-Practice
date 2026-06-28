public class PartitionEqualSubsetSumSolver {

    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if ((totalSum & 1) == 1) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {

            for (int sum = target;
                 sum >= num;
                 sum--) {

                dp[sum] =
                        dp[sum]
                        || dp[sum - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        PartitionEqualSubsetSumSolver solver =
                new PartitionEqualSubsetSumSolver();

        int[] nums = {1, 5, 11, 5};

        System.out.println(
                solver.canPartition(nums)
        );
    }
}
