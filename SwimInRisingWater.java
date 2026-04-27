import java.util.*;

public class SwimInRisingWater {

    static int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], time = curr[2];

            if (r == n-1 && c == n-1)
                return time;

            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] d : dirs) {

                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n
                        && !visited[nr][nc]) {

                    pq.offer(new int[]{
                            nr,
                            nc,
                            Math.max(time, grid[nr][nc])
                    });
                }
            }
        }

        return -1;
    }
}
