public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }

        // The minimum leftover equals the smallest difference between two groups.
        int half = total / 2;
        boolean[] reachable = new boolean[half + 1];
        reachable[0] = true;

        for (int stone : stones) {
            // Descending sums prevent using the same stone twice.
            for (int weight = half; weight >= stone; weight--) {
                reachable[weight] |= reachable[weight - stone];
            }
        }

        int smallerGroup = half;
        while (!reachable[smallerGroup]) {
            smallerGroup--;
        }
        return total - 2 * smallerGroup;
    }
}

// Time Complexity: O(n * (total + 1))
// Space Complexity: O(total + 1)
