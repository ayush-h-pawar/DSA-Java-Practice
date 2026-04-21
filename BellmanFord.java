import java.util.*;

public class BellmanFord {

    static int[] bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            for (int[] e : edges) {

                int u = e[0], v = e[1], wt = e[2];

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Detect negative cycle
        for (int[] e : edges) {

            int u = e[0], v = e[1], wt = e[2];

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + wt < dist[v]) {

                System.out.println("Negative cycle detected");
                return new int[]{};
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
                {0,1,6},
                {0,2,7},
                {1,2,8},
                {1,3,5},
                {1,4,-4},
                {2,3,-3},
                {2,4,9},
                {3,1,-2},
                {4,3,7}
        };

        int[] dist = bellmanFord(V, edges, 0);

        System.out.println(Arrays.toString(dist));
    }
}
