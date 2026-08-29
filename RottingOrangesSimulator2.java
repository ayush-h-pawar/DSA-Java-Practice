import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrangesSimulator2 {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue =
                new ArrayDeque<>();

        int fresh = 0;

        for (int row = 0; row < rows; row++) {

            for (int column = 0;
                 column < columns;
                 column++) {

                if (grid[row][column] == 2) {
                    queue.offer(
                            new int[]{row, column}
                    );
                } else if (grid[row][column] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty()
                && fresh > 0) {

            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                for (int[] direction :
                        directions) {

                    int nextRow =
                            current[0] + direction[0];

                    int nextColumn =
                            current[1] + direction[1];

                    if (nextRow >= 0
                            && nextRow < rows
                            && nextColumn >= 0
                            && nextColumn < columns
                            && grid[nextRow][nextColumn] == 1) {

                        grid[nextRow][nextColumn] = 2;
                        fresh--;

                        queue.offer(
                                new int[]{
                                        nextRow,
                                        nextColumn
                                }
                        );
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        RottingOrangesSimulator solver =
                new RottingOrangesSimulator();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(
                solver.orangesRotting(grid)
        );
    }
          }
