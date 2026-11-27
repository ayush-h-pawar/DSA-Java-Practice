public class WaysToStayAtOrigin {

    private static final int MOD = 1_000_000_007;

    public int numWays(int steps, int arrLen) {
        // A walk that returns to zero cannot reach beyond half its total steps.
        int width = Math.min(arrLen, steps / 2 + 1);
        int[] previous = new int[width + 2];
        int[] current = new int[width + 2];
        previous[1] = 1;

        for (int step = 0; step < steps; step++) {
            for (int index = 1; index <= width; index++) {
                long ways = (long) previous[index - 1] + previous[index] + previous[index + 1];
                current[index] = (int) (ways % MOD);
            }

            int[] swap = previous;
            previous = current;
            current = swap;
        }
        return previous[1];
    }
}

// Time Complexity: O((steps + 1) * min(arrLen, steps / 2 + 1))
// Space Complexity: O(min(arrLen, steps / 2 + 1))
