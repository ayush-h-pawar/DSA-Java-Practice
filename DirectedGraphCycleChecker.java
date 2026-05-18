import java.util.*;

public class DirectedGraphCycleChecker {

    static boolean hasCycle(int V,
                            List<List<Integer>> graph) {

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i,
                        visited,
                        pathVisited,
                        graph)) {

                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(int node,
                       boolean[] visited,
                       boolean[] pathVisited,
                       List<List<Integer>> graph) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor,
                        visited,
                        pathVisited,
                        graph)) {

                    return true;
                }

            } else if (pathVisited[neighbor]) {

                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);

        System.out.println(
                hasCycle(V, graph)
        );
    }
}
