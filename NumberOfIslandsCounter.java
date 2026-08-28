public class NumberOfIslandsCounter {

    public int numIslands(
            char[][] grid) {

        int islands = 0;

        for (int row = 0;
             row < grid.length;
             row++) {

            for (int column = 0;
                 column < grid[0].length;
                 column++) {

                if (grid[row][column] == '1') {

                    islands++;

                    explore(
                            grid,
                            row,
                            column
                    );
                }
            }
        }

        return islands;
    }

    private void explore(
            char[][] grid,
            int row,
            int column) {

        if (row < 0
                || row >= grid.length
                || column < 0
                || column >= grid[0].length
                || grid[row][column] != '1') {

            return;
        }

        grid[row][column] = '0';

        explore(
                grid,
                row + 1,
                column
        );

        explore(
                grid,
                row - 1,
                column
        );

        explore(
                grid,
                row,
                column + 1
        );

        explore(
                grid,
                row,
                column - 1
        );
    }

    public static void main(String[] args) {

        NumberOfIslandsCounter solver =
                new NumberOfIslandsCounter();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(
                solver.numIslands(grid)
        );
    }
}
