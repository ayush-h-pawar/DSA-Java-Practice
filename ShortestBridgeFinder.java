import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridgeFinder {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int shortestBridge(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        for (int r = 0; r < rows && !found; r++) {

            for (int c = 0; c < cols && !found; c++) {

                if (grid[r][c] == 1) {

                    markIsland(grid, r, c, queue);
                    found = true;
                }
            }
        }

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] current = queue.poll();

                for (int[] direction : DIRECTIONS) {

                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];

                    if (newRow < 0
                            || newRow >= rows
                            || newCol < 0
                            || newCol >= cols) {
                        continue;
                    }

                    if (grid[newRow][newCol] == 1) {
                        return distance;
                    }

                    if (grid[newRow][newCol] == 0) {

                        grid[newRow][newCol] = -1;

                        queue.offer(
                                new int[]{
                                        newRow,
                                        newCol
                                }
                        );
                    }
                }
            }

            distance++;
        }

        return -1;
    }

    private void markIsland(
            int[][] grid,
            int row,
            int col,
            Queue<int[]> queue) {

        if (row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length
                || grid[row][col] != 1) {

            return;
        }

        grid[row][col] = -1;

        queue.offer(
                new int[]{
                        row,
                        col
                }
        );

        for (int[] direction : DIRECTIONS) {

            markIsland(
                    grid,
                    row + direction[0],
                    col + direction[1],
                    queue
            );
        }
    }

    public static void main(String[] args) {

        ShortestBridgeFinder solver =
                new ShortestBridgeFinder();

        int[][] grid = {
                {0, 1},
                {1, 0}
        };

        System.out.println(
                solver.shortestBridge(grid)
        );
    }
}
