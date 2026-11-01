import java.util.Arrays;

public class HIndexCalculator {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int papers = n - i;

            if (citations[i] >= papers) {
                return papers;
            }
        }

        return 0;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(1) auxiliary space

