public class MatrixBlockSumCalculator {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefix = new int[rows + 1][cols + 1];
        int[][] result = new int[rows][cols];

        // Build the 2D prefix sum matrix
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        // Calculate each block sum
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(rows - 1, i + k);
                int c2 = Math.min(cols - 1, j + k);

                result[i][j] =
                        prefix[r2 + 1][c2 + 1]
                        - prefix[r1][c2 + 1]
                        - prefix[r2 + 1][c1]
                        + prefix[r1][c1];
            }
        }

        return result;
    }
}

// Time Complexity: O(m × n)
// Space Complexity: O(m × n)
// LeetCode: 1314 - Matrix Block Sum
