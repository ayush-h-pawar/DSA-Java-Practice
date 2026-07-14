import java.util.ArrayDeque;
import java.util.Queue;

public class WallsAndGatesSolver1 {

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;

    public void wallsAndGates(int[][] rooms) {

        if (rooms == null
                || rooms.length == 0
                || rooms[0].length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue =
                new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (rooms[row][col] == GATE) {

                    queue.offer(
                            new int[]{
                                    row,
                                    col
                            }
                    );
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] current =
                    queue.poll();

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
                        || newCol >= cols
                        || rooms[newRow][newCol] != EMPTY) {

                    continue;
                }

                rooms[newRow][newCol] =
                        rooms[row][col] + 1;

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

        WallsAndGatesSolver solver =
                new WallsAndGatesSolver();

        int INF = Integer.MAX_VALUE;

        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        solver.wallsAndGates(rooms);

        for (int[] row : rooms) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}
