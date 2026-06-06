public class KnightProbabilityChessboard {

    static double knightProbability(
            int n,
            int k,
            int row,
            int column) {

        double[][] dp =
                new double[n][n];

        dp[row][column] = 1.0;

        int[][] moves = {
                {-2,-1},
                {-2,1},
                {-1,-2},
                {-1,2},
                {1,-2},
                {1,2},
                {2,-1},
                {2,1}
        };

        for (int step = 0;
             step < k;
             step++) {

            double[][] next =
                    new double[n][n];

            for (int r = 0;
                 r < n;
                 r++) {

                for (int c = 0;
                     c < n;
                     c++) {

                    if (dp[r][c] > 0) {

                        for (int[] move :
                                moves) {

                            int nr =
                                    r + move[0];

                            int nc =
                                    c + move[1];

                            if (nr >= 0 &&
                                nr < n &&
                                nc >= 0 &&
                                nc < n) {

                                next[nr][nc]
                                        +=
                                        dp[r][c] / 8.0;
                            }
                        }
                    }
                }
            }

            dp = next;
        }

        double probability = 0;

        for (int r = 0;
             r < n;
             r++) {

            for (int c = 0;
                 c < n;
                 c++) {

                probability += dp[r][c];
            }
        }

        return probability;
    }

    public static void main(String[] args) {

        System.out.println(
                knightProbability(
                        3,
                        2,
                        0,
                        0
                )
        );
    }
          }
