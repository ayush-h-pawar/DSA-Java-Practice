import java.util.*;

public class ShortestBridge {

    static int shortestBridge(int[][] grid) {

        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // Step 1: find first island
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }

        // Step 2: BFS expansion
        int steps = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();

                for (int[] d : dirs) {

                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if (r >= 0 && c >= 0 && r < n && c < n) {

                        if (grid[r][c] == 1)
                            return steps;

                        if (grid[r][c] == 0) {
                            grid[r][c] = -1;
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    static void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {

        int n = grid.length;

        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return;

        grid[r][c] = -1;
        queue.offer(new int[]{r, c});

        dfs(grid, r+1, c, queue);
        dfs(grid, r-1, c, queue);
        dfs(grid, r, c+1, queue);
        dfs(grid, r, c-1, queue);
    }
            }
