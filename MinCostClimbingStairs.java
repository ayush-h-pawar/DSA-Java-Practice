public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prevTwo = 0;
        int prevOne = 0;

        for (int i = 2; i <= n; i++) {
            int current = Math.min(
                prevOne + cost[i - 1],
                prevTwo + cost[i - 2]
            );

            prevTwo = prevOne;
            prevOne = current;
        }

        return prevOne;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
