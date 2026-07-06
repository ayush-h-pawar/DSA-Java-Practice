import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    static class Cell {

        int row;
        int col;
        int effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort =
                new int[rows][cols];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        PriorityQueue<Cell> minHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                a.effort - b.effort
                );

        minHeap.offer(
                new Cell(
                        0,
                        0,
                        0
                )
        );

        while (!minHeap.isEmpty()) {

            Cell current =
                    minHeap.poll();

            if (current.row == rows - 1
                    && current.col == cols - 1) {

                return current.effort;
            }

            if (current.effort
                    > effort[current.row][current.col]) {
                continue;
            }

            for (int[] direction : DIRECTIONS) {

                int newRow =
                        current.row + direction[0];

                int newCol =
                        current.col + direction[1];

                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols) {
                    continue;
                }

                int newEffort =
                        Math.max(
                                current.effort,
                                Math.abs(
                                        heights[current.row][current.col]
                                                - heights[newRow][newCol]
                                )
                        );

                if (newEffort
                        < effort[newRow][newCol]) {

                    effort[newRow][newCol] =
                            newEffort;

                    minHeap.offer(
                            new Cell(
                                    newRow,
                                    newCol,
                                    newEffort
                            )
                    );
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        PathWithMinimumEffort solver =
                new PathWithMinimumEffort();

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(
                solver.minimumEffortPath(heights)
        );
    }
}
