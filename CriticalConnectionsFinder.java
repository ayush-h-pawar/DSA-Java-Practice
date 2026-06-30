import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsFinder {

    private int timer;

    public List<List<Integer>> criticalConnections(
            int n,
            List<List<Integer>> connections) {

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] discovery = new int[n];
        int[] low = new int[n];

        Arrays.fill(discovery, -1);

        List<List<Integer>> bridges =
                new ArrayList<>();

        timer = 0;

        dfs(
                0,
                -1,
                graph,
                discovery,
                low,
                bridges
        );

        return bridges;
    }

    private void dfs(
            int node,
            int parent,
            List<List<Integer>> graph,
            int[] discovery,
            int[] low,
            List<List<Integer>> bridges) {

        discovery[node] = timer;
        low[node] = timer;
        timer++;

        for (int neighbor : graph.get(node)) {

            if (neighbor == parent) {
                continue;
            }

            if (discovery[neighbor] == -1) {

                dfs(
                        neighbor,
                        node,
                        graph,
                        discovery,
                        low,
                        bridges
                );

                low[node] =
                        Math.min(
                                low[node],
                                low[neighbor]
                        );

                if (low[neighbor]
                        > discovery[node]) {

                    bridges.add(
                            Arrays.asList(
                                    node,
                                    neighbor
                            )
                    );
                }

            } else {

                low[node] =
                        Math.min(
                                low[node],
                                discovery[neighbor]
                        );
            }
        }
    }

    public static void main(String[] args) {

        CriticalConnectionsFinder solver =
                new CriticalConnectionsFinder();

        List<List<Integer>> edges =
                new ArrayList<>();

        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 0));
        edges.add(Arrays.asList(1, 3));

        System.out.println(
                solver.criticalConnections(
                        4,
                        edges
                )
        );
    }
}
