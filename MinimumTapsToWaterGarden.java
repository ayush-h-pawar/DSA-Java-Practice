public class MinimumTapsToWaterGarden {

    public int minTaps(int n, int[] ranges) {
        int[] farthestFrom = new int[n + 1];
        for (int tap = 0; tap <= n; tap++) {
            int left = Math.max(0, tap - ranges[tap]);
            int right = Math.min(n, tap + ranges[tap]);
            farthestFrom[left] = Math.max(farthestFrom[left], right);
        }

        int taps = 0;
        int covered = 0;
        int farthest = 0;

        for (int point = 0; point < n; point++) {
            farthest = Math.max(farthest, farthestFrom[point]);
            if (point == covered) {
                if (farthest <= covered) {
                    return -1;
                }
                // Every interval starting at or before covered has been considered.
                covered = farthest;
                taps++;
            }
        }

        return taps;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
