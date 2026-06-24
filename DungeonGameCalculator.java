public class DungeonGameCalculator {

    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        int[][] dp = new int[rows + 1][cols + 1];

        for (int r = 0; r <= rows; r++) {
            for (int c = 0; c <= cols; c++) {
                dp[r][c] = Integer.MAX_VALUE;
            }
        }

        dp[rows][cols - 1] = 1;
        dp[rows - 1][cols] = 1;

        for (int r = rows - 1; r >= 0; r--) {

            for (int c = cols - 1; c >= 0; c--) {

                int required =
                        Math.min(
                                dp[r + 1][c],
                                dp[r][c + 1]
                        ) - dungeon[r][c];

                dp[r][c] =
                        Math.max(
                                1,
                                required
                        );
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        DungeonGameCalculator solver =
                new DungeonGameCalculator();

        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        System.out.println(
                solver.calculateMinimumHP(dungeon)
        );
    }
}
