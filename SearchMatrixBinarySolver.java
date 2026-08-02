public class SearchMatrixBinarySolver {

    public boolean searchMatrix(
            int[][] matrix,
            int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int middle =
                    left + (right - left) / 2;

            int row =
                    middle / cols;

            int col =
                    middle % cols;

            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] < target) {

                left = middle + 1;

            } else {

                right = middle - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        SearchMatrixBinarySolver solver =
                new SearchMatrixBinarySolver();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(
                solver.searchMatrix(
                        matrix,
                        3
                )
        );
    }
}
