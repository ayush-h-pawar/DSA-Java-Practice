import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(
            int[][] heights) {

        List<List<Integer>> result =
                new ArrayList<>();

        if (heights == null
                || heights.length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific =
                new boolean[rows][cols];

        boolean[][] atlantic =
                new boolean[rows][cols];

        Queue<int[]> pacificQueue =
                new LinkedList<>();

        Queue<int[]> atlanticQueue =
                new LinkedList<>();

        for (int r = 0; r < rows; r++) {

            pacific[r][0] = true;
            pacificQueue.offer(new int[]{r, 0});

            atlantic[r][cols - 1] = true;
            atlanticQueue.offer(
                    new int[]{r, cols - 1}
            );
        }

        for (int c = 0; c < cols; c++) {

            pacific[0][c] = true;
            pacificQueue.offer(new int[]{0, c});

            atlantic[rows - 1][c] = true;
            atlanticQueue.offer(
                    new int[]{rows - 1, c}
            );
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (pacific[r][c]
                        && atlantic[r][c]) {

                    List<Integer> cell =
                            new ArrayList<>();

                    cell.add(r);
                    cell.add(c);

                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void bfs(
            int[][] heights,
            Queue<int[]> queue,
            boolean[][] visited) {

        int rows = heights.length;
        int cols = heights[0].length;

        while (!queue.isEmpty()) {

            int[] current =
                    queue.poll();

            for (int[] direction : DIRECTIONS) {

                int newRow =
                        current[0] + direction[0];

                int newCol =
                        current[1] + direction[1];

                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols
                        || visited[newRow][newCol]
                        || heights[newRow][newCol]
                        < heights[current[0]][current[1]]) {

                    continue;
                }

                visited[newRow][newCol] = true;

                queue.offer(
                        new int[]{
                                newRow,
                                newCol
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
