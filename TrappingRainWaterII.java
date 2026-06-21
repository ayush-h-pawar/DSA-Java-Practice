import java.util.PriorityQueue;

public class TrappingRainWaterII {

    static class Cell {

        int row;
        int col;
        int height;

        Cell(
                int row,
                int col,
                int height) {

            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public int trapRainWater(
            int[][] heightMap) {

        if (heightMap == null
                || heightMap.length == 0
                || heightMap[0].length == 0) {

            return 0;
        }

        int rows = heightMap.length;
        int cols = heightMap[0].length;

        boolean[][] visited =
                new boolean[rows][cols];

        PriorityQueue<Cell> minHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                a.height - b.height
                );

        for (int r = 0; r < rows; r++) {

            minHeap.offer(
                    new Cell(
                            r,
                            0,
                            heightMap[r][0]
                    )
            );

            minHeap.offer(
                    new Cell(
                            r,
                            cols - 1,
                            heightMap[r][cols - 1]
                    )
            );

            visited[r][0] = true;
            visited[r][cols - 1] = true;
        }

        for (int c = 1; c < cols - 1; c++) {

            minHeap.offer(
                    new Cell(
                            0,
                            c,
                            heightMap[0][c]
                    )
            );

            minHeap.offer(
                    new Cell(
                            rows - 1,
                            c,
                            heightMap[rows - 1][c]
                    )
            );

            visited[0][c] = true;
            visited[rows - 1][c] = true;
        }

        int trappedWater = 0;

        while (!minHeap.isEmpty()) {

            Cell current =
                    minHeap.poll();

            for (int[] direction :
                    DIRECTIONS) {

                int newRow =
                        current.row
                                + direction[0];

                int newCol =
                        current.col
                                + direction[1];

                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols
                        || visited[newRow][newCol]) {

                    continue;
                }

                visited[newRow][newCol] = true;

                trappedWater +=
                        Math.max(
                                0,
                                current.height
                                        - heightMap[newRow][newCol]
                        );

                minHeap.offer(
                        new Cell(
                                newRow,
                                newCol,
                                Math.max(
                                        current.height,
                                        heightMap[newRow][newCol]
                                )
                        )
                );
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {

        TrappingRainWaterII solver =
                new TrappingRainWaterII();

        int[][] heightMap = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };

        System.out.println(
                solver.trapRainWater(heightMap)
        );
    }
}
