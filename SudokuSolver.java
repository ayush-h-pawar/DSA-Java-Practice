public class SudokuSolver {

    static void solveSudoku(char[][] board) {
        backtrack(board);
    }

    static boolean backtrack(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, i, j, c)) {

                            board[i][j] = c;

                            if (backtrack(board))
                                return true;

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;

            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;

            if (board[subRow][subCol] == c)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);

        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
