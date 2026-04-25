import java.util.*;

public class CheapestFlightsWithinKStops {

    static int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>())
                 .add(new int[]{f[1], f[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0}); // node, cost, stops

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int node = curr[0], cost = curr[1], stops = curr[2];

            if (stops > k) continue;

            if (!graph.containsKey(node)) continue;

            for (int[] nei : graph.get(node)) {

                int next = nei[0];
                int price = nei[1];

                if (cost + price < dist[next]) {

                    dist[next] = cost + price;
                    queue.offer(new int[]{next, dist[next], stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
