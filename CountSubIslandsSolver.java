public class CountSubIslandsSolver {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int countSubIslands(
            int[][] grid1,
            int[][] grid2) {

        int rows = grid2.length;
        int cols = grid2[0].length;

        int subIslands = 0;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid2[row][col] == 1) {

                    if (dfs(
                            grid1,
                            grid2,
                            row,
                            col)) {

                        subIslands++;
                    }
                }
            }
        }

        return subIslands;
    }

    private boolean dfs(
            int[][] grid1,
            int[][] grid2,
            int row,
            int col) {

        if (row < 0
                || row >= grid2.length
                || col < 0
                || col >= grid2[0].length
                || grid2[row][col] == 0) {

            return true;
        }

        grid2[row][col] = 0;

        boolean isSubIsland =
                grid1[row][col] == 1;

        for (int[] direction : DIRECTIONS) {

            isSubIsland =
                    dfs(
                            grid1,
                            grid2,
                            row + direction[0],
                            col + direction[1]
                    ) && isSubIsland;
        }

        return isSubIsland;
    }

    public static void main(String[] args) {

        CountSubIslandsSolver solver =
                new CountSubIslandsSolver();

        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        System.out.println(
                solver.countSubIslands(
                        grid1,
                        grid2
                )
        );
    }
}
