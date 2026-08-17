public class EditDistanceCalculator {

    public int minDistance(
            String first,
            String second) {

        int rows = first.length();
        int columns = second.length();

        int[][] dp =
                new int[rows + 1][columns + 1];

        for (int row = 0;
             row <= rows;
             row++) {

            dp[row][0] = row;
        }

        for (int column = 0;
             column <= columns;
             column++) {

            dp[0][column] = column;
        }

        for (int row = 1;
             row <= rows;
             row++) {

            for (int column = 1;
                 column <= columns;
                 column++) {

                if (first.charAt(row - 1)
                        == second.charAt(column - 1)) {

                    dp[row][column] =
                            dp[row - 1][column - 1];

                } else {

                    int insert =
                            dp[row][column - 1];

                    int delete =
                            dp[row - 1][column];

                    int replace =
                            dp[row - 1][column - 1];

                    dp[row][column] =
                            1 + Math.min(
                                    insert,
                                    Math.min(
                                            delete,
                                            replace
                                    )
                            );
                }
            }
        }

        return dp[rows][columns];
    }

    public static void main(String[] args) {

        EditDistanceCalculator solver =
                new EditDistanceCalculator();

        System.out.println(
                solver.minDistance(
                        "horse",
                        "ros"
                )
        );
    }
}
