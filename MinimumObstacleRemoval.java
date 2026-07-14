import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumObstacleRemoval {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int minimumObstacles(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] distance =
                new int[rows][cols];

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                distance[r][c] = Integer.MAX_VALUE;
            }
        }

        Deque<int[]> deque =
                new ArrayDeque<>();

        deque.offerFirst(new int[]{0, 0});
        distance[0][0] = 0;

        while (!deque.isEmpty()) {

            int[] current = deque.pollFirst();

            int row = current[0];
            int col = current[1];

            for (int[] direction : DIRECTIONS) {

                int newRow =
                        row + direction[0];

                int newCol =
                        col + direction[1];

                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols) {
                    continue;
                }

                int newCost =
                        distance[row][col]
                                + grid[newRow][newCol];

                if (newCost
                        < distance[newRow][newCol]) {

                    distance[newRow][newCol] =
                            newCost;

                    if (grid[newRow][newCol] == 0) {

                        deque.offerFirst(
                                new int[]{
                                        newRow,
                                        newCol
                                }
                        );

                    } else {

                        deque.offerLast(
                                new int[]{
                                        newRow,
                                        newCol
                                }
                        );
                    }
                }
            }
        }

        return distance[rows - 1][cols - 1];
    }

    public static void main(String[] args) {

        MinimumObstacleRemoval solver =
                new MinimumObstacleRemoval();

        int[][] grid = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(
                solver.minimumObstacles(grid)
        );
    }
}
