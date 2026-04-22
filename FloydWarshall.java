import java.util.*;

public class FloydWarshall {

    static void floydWarshall(int[][] dist) {

        int n = dist.length;

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != Integer.MAX_VALUE &&
                        dist[k][j] != Integer.MAX_VALUE) {

                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int INF = Integer.MAX_VALUE;

        int[][] graph = {
                {0,   3, INF, 5},
                {2,   0, INF, 4},
                {INF, 1,   0, INF},
                {INF, INF, 2, 0}
        };

        floydWarshall(graph);

        for (int[] row : graph)
            System.out.println(Arrays.toString(row));
    }
}
