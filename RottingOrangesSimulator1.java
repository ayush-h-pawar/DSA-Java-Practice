import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesSimulator1 {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue =
                new LinkedList<>();

        int fresh = 0;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {

                    queue.offer(new int[]{r, c});

                } else if (grid[r][c] == 1) {

                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            while (size-- > 0) {

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
                            || grid[newRow][newCol] != 1) {

                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    fresh--;

                    queue.offer(
                            new int[]{
                                    newRow,
                                    newCol
                            }
                    );
                }
            }

            minutes++;
        }

        return fresh == 0
                ? minutes
                : -1;
    }

    public static void main(String[] args) {

        RottingOrangesSimulator solver =
                new RottingOrangesSimulator();

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println(
                solver.orangesRotting(grid)
        );
    }
}
