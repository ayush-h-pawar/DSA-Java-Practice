public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // Before each update, advantage[right] describes [left + 1, right].
        int[] advantage = new int[n];
        for (int left = n - 2; left >= 0; left--) {
            for (int right = left + 1; right < n; right++) {
                int removeLeft = prefix[right + 1] - prefix[left + 1] - advantage[right];
                int removeRight = prefix[right] - prefix[left] - advantage[right - 1];
                advantage[right] = Math.max(removeLeft, removeRight);
            }
        }
        return advantage[n - 1];
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n)
