import java.util.*;

public class LargestIsland {

    static int n;

    static int largestIsland(int[][] grid) {

        n = grid.length;
        Map<Integer, Integer> areaMap = new HashMap<>();
        int id = 2;

        // Step 1: label islands
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, id);
                    areaMap.put(id, area);
                    id++;
                }
            }
        }

        int max = 0;

        // Step 2: try flipping 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    Set<Integer> seen = new HashSet<>();
                    int area = 1;

                    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

                    for (int[] d : dirs) {

                        int r = i + d[0], c = j + d[1];

                        if (r >= 0 && c >= 0 && r < n && c < n
                                && grid[r][c] > 1) {

                            int idx = grid[r][c];
                            if (!seen.contains(idx)) {
                                area += areaMap.get(idx);
                                seen.add(idx);
                            }
                        }
                    }

                    max = Math.max(max, area);
                }
            }
        }

        // edge case: all 1s
        for (int val : areaMap.values()) {
            max = Math.max(max, val);
        }

        return max == 0 ? n * n : max;
    }

    static int dfs(int[][] grid, int r, int c, int id) {

        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return 0;

        grid[r][c] = id;

        return 1
            + dfs(grid, r+1, c, id)
            + dfs(grid, r-1, c, id)
            + dfs(grid, r, c+1, id)
            + dfs(grid, r, c-1, id);
    }
  }
