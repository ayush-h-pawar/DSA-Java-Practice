import java.util.*;

public class ShortestPathWithObstaclesElimination1 {

    static int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][][] visited =
                new boolean[m][n][k + 1];

        queue.offer(new int[]{0, 0, k, 0});

        visited[0][0][k] = true;

        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];
            int remain = curr[2];
            int steps = curr[3];

            if (r == m - 1 && c == n - 1)
                return steps;

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n) {

                    int nextRemain =
                            remain - grid[nr][nc];

                    if (nextRemain >= 0 &&
                        !visited[nr][nc][nextRemain]) {

                        visited[nr][nc][nextRemain] = true;

                        queue.offer(new int[]{
                                nr,
                                nc,
                                nextRemain,
                                steps + 1
                        });
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };

        System.out.println(shortestPath(grid, 1));
    }
    }
