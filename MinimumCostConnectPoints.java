import java.util.PriorityQueue;

public class MinimumCostConnectPoints {

    static class Edge {

        int point;
        int cost;

        Edge(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];
        int visitedCount = 0;
        int totalCost = 0;

        PriorityQueue<Edge> minHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                a.cost - b.cost
                );

        minHeap.offer(new Edge(0, 0));

        while (visitedCount < n) {

            Edge current = minHeap.poll();

            if (visited[current.point]) {
                continue;
            }

            visited[current.point] = true;
            visitedCount++;
            totalCost += current.cost;

            for (int next = 0; next < n; next++) {

                if (!visited[next]) {

                    int distance =
                            Math.abs(
                                    points[current.point][0]
                                            - points[next][0]
                            )
                                    +
                                    Math.abs(
                                            points[current.point][1]
                                                    - points[next][1]
                                    );

                    minHeap.offer(
                            new Edge(
                                    next,
                                    distance
                            )
                    );
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {

        MinimumCostConnectPoints solver =
                new MinimumCostConnectPoints();

        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        System.out.println(
                solver.minCostConnectPoints(points)
        );
    }
}
