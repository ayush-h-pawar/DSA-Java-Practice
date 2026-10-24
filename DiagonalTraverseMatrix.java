public class DiagonalTraverseMatrix {

    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];

        int row = 0;
        int col = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];

            if ((row + col) % 2 == 0) {
                if (col == cols - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == rows - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}

// Time Complexity: O(m × n)
// Space Complexity: O(1) auxiliary space, excluding the result
// LeetCode: 498 - Diagonal Traverse
