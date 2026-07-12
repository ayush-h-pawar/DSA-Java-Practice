public class LongestCycleDirectedGraph {

    public int longestCycle(int[] edges) {

        int n = edges.length;

        boolean[] visited = new boolean[n];

        int longest = -1;

        for (int start = 0; start < n; start++) {

            if (visited[start]) {
                continue;
            }

            int current = start;
            int distance = 0;

            java.util.HashMap<Integer, Integer> order =
                    new java.util.HashMap<>();

            while (current != -1
                    && !visited[current]) {

                visited[current] = true;

                order.put(current, distance++);

                current = edges[current];
            }

            if (current != -1
                    && order.containsKey(current)) {

                longest = Math.max(
                        longest,
                        distance - order.get(current)
                );
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        LongestCycleDirectedGraph solver =
                new LongestCycleDirectedGraph();

        int[] edges = {
                3,
                3,
                4,
                2,
                3
        };

        System.out.println(
                solver.longestCycle(edges)
        );
    }
}
