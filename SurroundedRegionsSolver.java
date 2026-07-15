import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegionsSolver {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public void solve(char[][] board) {

        if (board == null
                || board.length == 0
                || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue =
                new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {

            if (board[row][0] == 'O') {
                mark(board, row, 0, queue);
            }

            if (board[row][cols - 1] == 'O') {
                mark(board, row, cols - 1, queue);
            }
        }

        for (int col = 0; col < cols; col++) {

            if (board[0][col] == 'O') {
                mark(board, 0, col, queue);
            }

            if (board[rows - 1][col] == 'O') {
                mark(board, rows - 1, col, queue);
            }
        }

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int[] direction : DIRECTIONS) {

                int newRow =
                        current[0] + direction[0];

                int newCol =
                        current[1] + direction[1];

                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols
                        || board[newRow][newCol] != 'O') {
                    continue;
                }

                mark(board, newRow, newCol, queue);
            }
        }

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {

                    board[row][col] = 'X';

                } else if (board[row][col] == '#') {

                    board[row][col] = 'O';
                }
            }
        }
    }

    private void mark(
            char[][] board,
            int row,
            int col,
            Queue<int[]> queue) {

        board[row][col] = '#';

        queue.offer(
                new int[]{
                        row,
                        col
                }
        );
    }

    public static void main(String[] args) {

        SurroundedRegionsSolver solver =
                new SurroundedRegionsSolver();

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        solver.solve(board);

        for (char[] row : board) {

            for (char cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }
}
