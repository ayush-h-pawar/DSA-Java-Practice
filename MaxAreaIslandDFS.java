public class MaxAreaIslandDFS {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maximumArea = 0;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {

                    maximumArea = Math.max(
                            maximumArea,
                            dfs(
                                    grid,
                                    row,
                                    col
                            )
                    );
                }
            }
        }

        return maximumArea;
    }

    private int dfs(
            int[][] grid,
            int row,
            int col) {

        if (row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length
                || grid[row][col] == 0) {

            return 0;
        }

        grid[row][col] = 0;

        int area = 1;

        for (int[] direction : DIRECTIONS) {

            area += dfs(
                    grid,
                    row + direction[0],
                    col + direction[1]
            );
        }

        return area;
    }

    public static void main(String[] args) {

        MaxAreaIslandDFS solver =
                new MaxAreaIslandDFS();

        int[][] grid = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(
                solver.maxAreaOfIsland(grid)
        );
    }
}
