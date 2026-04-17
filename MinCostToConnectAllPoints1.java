import java.util.*;

public class MinCostToConnectAllPoints1 {

    static int minCostConnectPoints(int[][] points) {

        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{0, 0});

        int cost = 0, edges = 0;

        while (edges < n) {

            int[] curr = pq.poll();
            int node = curr[0];
            int wt = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            cost += wt;
            edges++;

            for (int i = 0; i < n; i++) {

                if (!visited[i]) {

                    int dist = Math.abs(points[node][0] - points[i][0])
                             + Math.abs(points[node][1] - points[i][1]);

                    pq.offer(new int[]{i, dist});
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points)); // 20
    }
}
