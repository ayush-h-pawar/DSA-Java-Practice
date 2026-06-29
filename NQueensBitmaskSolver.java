import java.util.ArrayList;
import java.util.List;

public class NQueensBitmaskSolver {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }

        solve(
                0,
                n,
                0,
                0,
                0,
                board,
                solutions
        );

        return solutions;
    }

    private void solve(
            int row,
            int n,
            int columns,
            int diagonal,
            int antiDiagonal,
            char[][] board,
            List<List<String>> solutions) {

        if (row == n) {

            List<String> configuration =
                    new ArrayList<>();

            for (char[] currentRow : board) {
                configuration.add(
                        new String(currentRow)
                );
            }

            solutions.add(configuration);
            return;
        }

        int available =
                ((1 << n) - 1)
                        & ~(columns | diagonal | antiDiagonal);

        while (available != 0) {

            int position =
                    available & -available;

            available -= position;

            int column =
                    Integer.numberOfTrailingZeros(position);

            board[row][column] = 'Q';

            solve(
                    row + 1,
                    n,
                    columns | position,
                    (diagonal | position) << 1,
                    (antiDiagonal | position) >> 1,
                    board,
                    solutions
            );

            board[row][column] = '.';
        }
    }

    public static void main(String[] args) {

        NQueensBitmaskSolver solver =
                new NQueensBitmaskSolver();

        List<List<String>> result =
                solver.solveNQueens(4);

        for (List<String> board : result) {

            for (String row : board) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}
