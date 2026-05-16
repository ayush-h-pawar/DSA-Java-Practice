import java.util.*;

public class MatrixDiagonalTraversal {

    static int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;

        int[] result = new int[m * n];

        int row = 0;
        int col = 0;

        int dir = 1;

        for (int i = 0; i < result.length; i++) {

            result[i] = matrix[row][col];

            if (dir == 1) {

                if (col == n - 1) {
                    row++;
                    dir = -1;

                } else if (row == 0) {
                    col++;
                    dir = -1;

                } else {
                    row--;
                    col++;
                }

            } else {

                if (row == m - 1) {
                    col++;
                    dir = 1;

                } else if (col == 0) {
                    row++;
                    dir = 1;

                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println(
                Arrays.toString(
                        findDiagonalOrder(matrix)
                )
        );
    }
}
