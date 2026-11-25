public class PolygonTriangulationMinimumScore {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] minimum = new int[n][n];

        for (int span = 2; span < n; span++) {
            for (int left = 0; left + span < n; left++) {
                int right = left + span;
                int best = Integer.MAX_VALUE;
                // Choose the triangle adjacent to the edge joining left and right.
                for (int middle = left + 1; middle < right; middle++) {
                    int score = values[left] * values[middle] * values[right];
                    score += minimum[left][middle] + minimum[middle][right];
                    best = Math.min(best, score);
                }
                minimum[left][right] = best;
            }
        }
        return minimum[0][n - 1];
    }
}

// Time Complexity: O(n^3)
// Space Complexity: O(n^2)
