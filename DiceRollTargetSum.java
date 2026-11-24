public class DiceRollTargetSum {

    private static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > (long) n * k) {
            return 0;
        }

        int[] previous = new int[target + 1];
        int[] current = new int[target + 1];
        previous[0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            int window = 0;
            current[0] = 0;
            for (int sum = 1; sum <= target; sum++) {
                // The last die can contribute any face value from 1 through k.
                window += previous[sum - 1];
                if (window >= MOD) {
                    window -= MOD;
                }
                if (sum > k) {
                    window -= previous[sum - k - 1];
                    if (window < 0) {
                        window += MOD;
                    }
                }
                current[sum] = window;
            }

            int[] swap = previous;
            previous = current;
            current = swap;
        }

        return previous[target];
    }
}

// Time Complexity: O(n * target)
// Space Complexity: O(target)
