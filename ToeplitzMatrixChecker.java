public class ToeplitzMatrixChecker {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// Time Complexity: O(m × n)
// Space Complexity: O(1)
// LeetCode: 766 - Toeplitz Matrix
