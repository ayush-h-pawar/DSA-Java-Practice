public class LongestIncreasingPathMatrix1 {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null
                || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] memo =
                new int[rows][cols];

        int answer = 0;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                answer =
                        Math.max(
                                answer,
                                dfs(
                                        matrix,
                                        r,
                                        c,
                                        memo
                                )
                        );
            }
        }

        return answer;
    }

    private int dfs(
            int[][] matrix,
            int row,
            int col,
            int[][] memo) {

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int best = 1;

        for (int[] direction : DIRECTIONS) {

            int newRow =
                    row + direction[0];

            int newCol =
                    col + direction[1];

            if (newRow >= 0
                    && newRow < matrix.length
                    && newCol >= 0
                    && newCol < matrix[0].length
                    && matrix[newRow][newCol]
                    > matrix[row][col]) {

                best =
                        Math.max(
                                best,
                                1 + dfs(
                                        matrix,
                                        newRow,
                                        newCol,
                                        memo
                                )
                        );
            }
        }

        memo[row][col] = best;
        return best;
    }

    public static void main(String[] args) {

        LongestIncreasingPathMatrix solver =
                new LongestIncreasingPathMatrix();

        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        System.out.println(
                solver.longestIncreasingPath(matrix)
        );
    }
}
