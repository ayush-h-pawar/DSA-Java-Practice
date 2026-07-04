import java.util.PriorityQueue;

public class SwimInRisingWater1 {

    static class Cell {

        int row;
        int col;
        int time;

        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        boolean[][] visited =
                new boolean[n][n];

        PriorityQueue<Cell> minHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                a.time - b.time
                );

        minHeap.offer(
                new Cell(
                        0,
                        0,
                        grid[0][0]
                )
        );

        while (!minHeap.isEmpty()) {

            Cell current =
                    minHeap.poll();

            if (visited[current.row][current.col]) {
                continue;
            }

            visited[current.row][current.col] = true;

            if (current.row == n - 1
                    && current.col == n - 1) {

                return current.time;
            }

            for (int[] direction : DIRECTIONS) {

                int newRow =
                        current.row + direction[0];

                int newCol =
                        current.col + direction[1];

                if (newRow >= 0
                        && newRow < n
                        && newCol >= 0
                        && newCol < n
                        && !visited[newRow][newCol]) {

                    minHeap.offer(
                            new Cell(
                                    newRow,
                                    newCol,
                                    Math.max(
                                            current.time,
                                            grid[newRow][newCol]
                                    )
                            )
                    );
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        SwimInRisingWater solver =
                new SwimInRisingWater();

        int[][] grid = {
                {0, 2},
                {1, 3}
        };

        System.out.println(
                solver.swimInWater(grid)
        );
    }
}
