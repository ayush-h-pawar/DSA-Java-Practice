public class SetMatrixZeroes {

    static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        // check first row
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }

        // check first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        // mark rows & cols
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 ||
                    matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        // first row
        if (firstRow) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // first column
        if (firstCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
