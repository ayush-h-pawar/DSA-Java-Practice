public class LongestIncreasingPathMatrix {

    static int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    static int longestIncreasingPath(
            int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] memo =
                new int[rows][cols];

        int answer = 0;

        for (int i = 0;
             i < rows;
             i++) {

            for (int j = 0;
                 j < cols;
                 j++) {

                answer =
                        Math.max(
                                answer,
                                dfs(
                                        matrix,
                                        i,
                                        j,
                                        memo
                                )
                        );
            }
        }

        return answer;
    }

    static int dfs(
            int[][] matrix,
            int row,
            int col,
            int[][] memo) {

        if (memo[row][col] != 0)
            return memo[row][col];

        int best = 1;

        for (int[] dir : dirs) {

            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 &&
                nr < matrix.length &&
                nc >= 0 &&
                nc < matrix[0].length &&
                matrix[nr][nc] >
                matrix[row][col]) {

                best =
                        Math.max(
                                best,
                                1 + dfs(
                                        matrix,
                                        nr,
                                        nc,
                                        memo
                                )
                        );
            }
        }

        memo[row][col] = best;

        return best;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };

        System.out.println(
                longestIncreasingPath(
                        matrix
                )
        );
    }
}
