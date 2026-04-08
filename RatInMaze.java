import java.util.*;

public class RatInMaze {

    static void solve(int[][] maze, int r, int c,
                      String path, List<String> result,
                      boolean[][] visited) {

        int n = maze.length;

        if (r == n - 1 && c == n - 1) {
            result.add(path);
            return;
        }

        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] move = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < n
                    && maze[nr][nc] == 1 && !visited[nr][nc]) {

                visited[r][c] = true;

                solve(maze, nr, nc,
                        path + move[i], result, visited);

                visited[r][c] = false;
            }
        }
    }

    static List<String> findPath(int[][] maze) {

        List<String> result = new ArrayList<>();

        if (maze[0][0] == 0) return result;

        boolean[][] visited = new boolean[maze.length][maze.length];

        solve(maze, 0, 0, "", result, visited);

        return result;
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };

        System.out.println(findPath(maze));
    }
                  }
