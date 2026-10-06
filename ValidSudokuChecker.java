public class ValidSudokuChecker {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                int number = board[row][col] - '1';
                int box = (row / 3) * 3 + col / 3;

                if (rows[row][number] ||
                    columns[col][number] ||
                    boxes[box][number]) {
                    return false;
                }

                rows[row][number] = true;
                columns[col][number] = true;
                boxes[box][number] = true;
            }
        }

        return true;
    }
}

// Time Complexity: O(1)
// Space Complexity: O(1)
// LeetCode: 36 - Valid Sudoku
