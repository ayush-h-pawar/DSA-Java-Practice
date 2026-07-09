import java.util.ArrayList;
import java.util.List;

public class DetonateMaximumBombs {

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r = bombs[i][2];

            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1 - x2;
                long dy = y1 - y2;

                if (dx * dx + dy * dy <= r * r) {
                    graph.get(i).add(j);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            boolean[] visited =
                    new boolean[n];

            answer = Math.max(
                    answer,
                    dfs(
                            i,
                            graph,
                            visited
                    )
            );
        }

        return answer;
    }

    private int dfs(
            int bomb,
            List<List<Integer>> graph,
            boolean[] visited) {

        if (visited[bomb]) {
            return 0;
        }

        visited[bomb] = true;

        int count = 1;

        for (int next :
                graph.get(bomb)) {

            count += dfs(
                    next,
                    graph,
                    visited
            );
        }

        return count;
    }

    public static void main(String[] args) {

        DetonateMaximumBombs solver =
                new DetonateMaximumBombs();

        int[][] bombs = {
                {2, 1, 3},
                {6, 1, 4}
        };

        System.out.println(
                solver.maximumDetonation(
                        bombs
                )
        );
    }
}
