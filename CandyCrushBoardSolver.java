public class CandyCrushBoardSolver {

    static int[][] candyCrush(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        boolean found = true;

        while (found) {

            found = false;

            // mark rows
            for (int i = 0; i < rows; i++) {

                for (int j = 0;
                     j < cols - 2;
                     j++) {

                    int val =
                            Math.abs(board[i][j]);

                    if (val != 0 &&
                        val ==
                        Math.abs(board[i][j + 1]) &&
                        val ==
                        Math.abs(board[i][j + 2])) {

                        found = true;

                        board[i][j] =
                                -val;

                        board[i][j + 1] =
                                -val;

                        board[i][j + 2] =
                                -val;
                    }
                }
            }

            // mark cols
            for (int j = 0; j < cols; j++) {

                for (int i = 0;
                     i < rows - 2;
                     i++) {

                    int val =
                            Math.abs(board[i][j]);

                    if (val != 0 &&
                        val ==
                        Math.abs(board[i + 1][j]) &&
                        val ==
                        Math.abs(board[i + 2][j])) {

                        found = true;

                        board[i][j] =
                                -val;

                        board[i + 1][j] =
                                -val;

                        board[i + 2][j] =
                                -val;
                    }
                }
            }

            // drop candies
            for (int j = 0; j < cols; j++) {

                int write =
                        rows - 1;

                for (int i = rows - 1;
                     i >= 0;
                     i--) {

                    if (board[i][j] > 0) {

                        board[write--][j] =
                                board[i][j];
                    }
                }

                while (write >= 0) {

                    board[write--][j] = 0;
                }
            }
        }

        return board;
    }
                          }
