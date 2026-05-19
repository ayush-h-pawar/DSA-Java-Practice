import java.util.*;

public class WallsAndGatesSolver {

    static final int INF = 2147483647;

    static void wallsAndGates(int[][] rooms) {

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue =
                new LinkedList<>();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (rooms[i][j] == 0) {

                    queue.offer(
                            new int[]{i, j}
                    );
                }
            }
        }

        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            for (int[] d : dirs) {

                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < rows && nc < cols &&
                    rooms[nr][nc] == INF) {

                    rooms[nr][nc] =
                            rooms[curr[0]][curr[1]] + 1;

                    queue.offer(
                            new int[]{nr, nc}
                    );
                }
            }
        }
    }
}
