import java.util.*;

public class MinCostToConnectAllPoints {

    static int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{0, 0}); // {index, cost}

        int cost = 0, edges = 0;

        while (edges < n) {

            int[] curr = pq.poll();
            int i = curr[0];
            int c = curr[1];

            if (visited[i]) continue;

            visited[i] = true;
            cost += c;
            edges++;

            for (int j = 0; j < n; j++) {

                if (!visited[j]) {

                    int dist = Math.abs(points[i][0] - points[j][0])
                             + Math.abs(points[i][1] - points[j][1]);

                    pq.offer(new int[]{j, dist});
                }
            }
        }

        return cost;
    }
}
