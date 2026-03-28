import java.util.*;

public class DetectCycleInDirectedGraph1 {

    static boolean hasCycle(int V, List<List<Integer>> graph) {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, graph, visited, recStack))
                return true;
        }

        return false;
    }

    static boolean dfs(int node, List<List<Integer>> graph,
                       boolean[] visited, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        for (int nei : graph.get(node)) {

            if (!visited[nei] && dfs(nei, graph, visited, recStack))
                return true;

            if (recStack[nei])
                return true;
        }

        recStack[node] = false;
        return false;
    }
}
