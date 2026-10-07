public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        if (rows * cols != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        for (int index = 0; index < rows * cols; index++) {
            result[index / c][index % c] = mat[index / cols][index % cols];
        }

        return result;
    }
}

// Time Complexity: O(m × n)
// Space Complexity: O(r × c)
// LeetCode: 566 - Reshape the Matrix
