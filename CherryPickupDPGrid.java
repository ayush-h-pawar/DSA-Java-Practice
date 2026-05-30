public class CherryPickupDPGrid {

    static int[][][] memo;

    static int cherryPickup(int[][] grid) {

        int n = grid.length;

        memo = new int[n][n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {

                    memo[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return Math.max(0,
                dfs(grid, 0, 0, 0));
    }

    static int dfs(int[][] grid,
                   int r1,
                   int c1,
                   int r2) {

        int c2 = r1 + c1 - r2;

        int n = grid.length;

        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {

            return -999999;
        }

        if (r1 == n - 1 &&
            c1 == n - 1) {

            return grid[r1][c1];
        }

        if (memo[r1][c1][r2] !=
            Integer.MIN_VALUE) {

            return memo[r1][c1][r2];
        }

        int cherries = grid[r1][c1];

        if (r1 != r2 ||
            c1 != c2) {

            cherries += grid[r2][c2];
        }

        int best = Math.max(
                Math.max(
                        dfs(grid,
                            r1 + 1,
                            c1,
                            r2 + 1),

                        dfs(grid,
                            r1,
                            c1 + 1,
                            r2)
                ),
                Math.max(
                        dfs(grid,
                            r1 + 1,
                            c1,
                            r2),

                        dfs(grid,
                            r1,
                            c1 + 1,
                            r2 + 1)
                )
        );

        cherries += best;

        memo[r1][c1][r2] =
                cherries;

        return cherries;
    }
    }
