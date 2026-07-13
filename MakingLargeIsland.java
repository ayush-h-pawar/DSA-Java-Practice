public class MakingLargeIsland {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        int islandId = 2;

        int[] islandArea =
                new int[n * n + 2];

        int maxArea = 0;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) {

                    islandArea[islandId] =
                            dfs(
                                    grid,
                                    row,
                                    col,
                                    islandId
                            );

                    maxArea = Math.max(
                            maxArea,
                            islandArea[islandId]
                    );

                    islandId++;
                }
            }
        }

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                if (grid[row][col] != 0) {
                    continue;
                }

                java.util.HashSet<Integer> used =
                        new java.util.HashSet<>();

                int currentArea = 1;

                for (int[] direction : DIRECTIONS) {

                    int newRow =
                            row + direction[0];

                    int newCol =
                            col + direction[1];

                    if (newRow < 0
                            || newRow >= n
                            || newCol < 0
                            || newCol >= n) {
                        continue;
                    }

                    int id =
                            grid[newRow][newCol];

                    if (id > 1
                            && used.add(id)) {

                        currentArea +=
                                islandArea[id];
                    }
                }

                maxArea =
                        Math.max(
                                maxArea,
                                currentArea
                        );
            }
        }

        return maxArea == 0
                ? n * n
                : maxArea;
    }

    private int dfs(
            int[][] grid,
            int row,
            int col,
            int islandId) {

        int n = grid.length;

        if (row < 0
                || row >= n
                || col < 0
                || col >= n
                || grid[row][col] != 1) {

            return 0;
        }

        grid[row][col] = islandId;

        int area = 1;

        for (int[] direction : DIRECTIONS) {

            area += dfs(
                    grid,
                    row + direction[0],
                    col + direction[1],
                    islandId
            );
        }

        return area;
    }

    public static void main(String[] args) {

        MakingLargeIsland solver =
                new MakingLargeIsland();

        int[][] grid = {
                {1, 0},
                {0, 1}
        };

        System.out.println(
                solver.largestIsland(grid)
        );
    }
}
