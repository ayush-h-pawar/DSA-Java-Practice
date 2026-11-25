public class MaximumChunksToMakeSortedII {

    public int maxChunksToSorted(int[] arr) {
        int[] maxima = new int[arr.length];
        int chunks = 0;

        for (int value : arr) {
            int maximum = value;
            // Merge every trailing chunk whose maximum exceeds the new value.
            while (chunks > 0 && maxima[chunks - 1] > value) {
                maximum = Math.max(maximum, maxima[--chunks]);
            }
            maxima[chunks++] = maximum;
        }
        return chunks;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
