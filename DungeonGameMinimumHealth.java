public class DungeonGameMinimumHealth {

    static int calculateMinimumHP(
            int[][] dungeon) {

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        int[][] dp =
                new int[rows + 1][cols + 1];

        for (int i = 0; i <= rows; i++) {

            for (int j = 0; j <= cols; j++) {

                dp[i][j] =
                        Integer.MAX_VALUE;
            }
        }

        dp[rows][cols - 1] = 1;
        dp[rows - 1][cols] = 1;

        for (int i = rows - 1; i >= 0; i--) {

            for (int j = cols - 1; j >= 0; j--) {

                int need =
                        Math.min(
                                dp[i + 1][j],
                                dp[i][j + 1]
                        ) - dungeon[i][j];

                dp[i][j] =
                        Math.max(1, need);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        int[][] dungeon = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };

        System.out.println(
                calculateMinimumHP(dungeon)
        );
    }
}
