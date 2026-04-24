import java.util.*;

public class MaxFlowFordFulkerson {

    static boolean bfs(int[][] residual, int s, int t, int[] parent) {

        int V = residual.length;
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v = 0; v < V; v++) {

                if (!visited[v] && residual[u][v] > 0) {
                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[t];
    }

    static int maxFlow(int[][] capacity, int s, int t) {

        int V = capacity.length;
        int[][] residual = new int[V][V];

        for (int i = 0; i < V; i++)
            residual[i] = capacity[i].clone();

        int[] parent = new int[V];
        int maxFlow = 0;

        while (bfs(residual, s, t, parent)) {

            int pathFlow = Integer.MAX_VALUE;

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {

        int[][] capacity = {
                {0,16,13,0,0,0},
                {0,0,10,12,0,0},
                {0,4,0,0,14,0},
                {0,0,9,0,0,20},
                {0,0,0,7,0,4},
                {0,0,0,0,0,0}
        };

        System.out.println(maxFlow(capacity, 0, 5)); // Output: 23
    }
          }
