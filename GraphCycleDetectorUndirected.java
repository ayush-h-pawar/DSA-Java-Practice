import java.util.*;

public class GraphCycleDetectorUndirected {

    static boolean hasCycle(int V,
                            List<List<Integer>> graph) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, visited, graph))
                    return true;
            }
        }

        return false;
    }

    static boolean dfs(int node,
                       int parent,
                       boolean[] visited,
                       List<List<Integer>> graph) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor,
                        node,
                        visited,
                        graph)) {

                    return true;
                }

            } else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(1);
        graph.get(1).add(3);

        System.out.println(
                hasCycle(V, graph)
        );
    }
    }
