public class RotateMatrixClockwise {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Reverse every row
        for (int row = 0; row < n; row++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;

                left++;
                right--;
            }
        }
    }
}

// Time Complexity: O(n²)
// Space Complexity: O(1)
// LeetCode: 48 - Rotate Image
