import java.util.*;

public class PacificAtlanticWaterFlow1 {

    private int rows;
    private int columns;

    private final int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(
            int[][] heights) {

        rows = heights.length;
        columns = heights[0].length;

        boolean[][] pacific =
                new boolean[rows][columns];

        boolean[][] atlantic =
                new boolean[rows][columns];

        Queue<int[]> pacificQueue =
                new ArrayDeque<>();

        Queue<int[]> atlanticQueue =
                new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {

            addCell(
                    row,
                    0,
                    pacific,
                    pacificQueue
            );

            addCell(
                    row,
                    columns - 1,
                    atlantic,
                    atlanticQueue
            );
        }

        for (int column = 0;
             column < columns;
             column++) {

            addCell(
                    0,
                    column,
                    pacific,
                    pacificQueue
            );

            addCell(
                    rows - 1,
                    column,
                    atlantic,
                    atlanticQueue
            );
        }

        bfs(
                heights,
                pacific,
                pacificQueue
        );

        bfs(
                heights,
                atlantic,
                atlanticQueue
        );

        List<List<Integer>> result =
                new ArrayList<>();

        for (int row = 0;
             row < rows;
             row++) {

            for (int column = 0;
                 column < columns;
                 column++) {

                if (pacific[row][column]
                        && atlantic[row][column]) {

                    result.add(
                            Arrays.asList(
                                    row,
                                    column
                            )
                    );
                }
            }
        }

        return result;
    }

    private void addCell(
            int row,
            int column,
            boolean[][] visited,
            Queue<int[]> queue) {

        if (!visited[row][column]) {

            visited[row][column] = true;

            queue.offer(
                    new int[]{
                            row,
                            column
                    }
            );
        }
    }

    private void bfs(
            int[][] heights,
            boolean[][] visited,
            Queue<int[]> queue) {

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int row = cell[0];
            int column = cell[1];

            for (int[] direction :
                    directions) {

                int nextRow =
                        row + direction[0];

                int nextColumn =
                        column + direction[1];

                if (nextRow < 0
                        || nextRow >= rows
                        || nextColumn < 0
                        || nextColumn >= columns
                        || visited[nextRow][nextColumn]
                        || heights[nextRow][nextColumn]
                        < heights[row][column]) {

                    continue;
                }

                visited[nextRow][nextColumn] = true;

                queue.offer(
                        new int[]{
                                nextRow,
                                nextColumn
                        }
                );
            }
        }
    }

    public static void main(String[] args) {

        PacificAtlanticWaterFlow solver =
                new PacificAtlanticWaterFlow();

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(
                solver.pacificAtlantic(heights)
        );
    }
}
