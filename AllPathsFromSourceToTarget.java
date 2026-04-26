import java.util.*;

public class AllPathsFromSourceToTarget {

    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, graph, path, result);

        return result;
    }

    static void dfs(int node, int[][] graph,
                    List<Integer> path,
                    List<List<Integer>> result) {

        path.add(node);

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {

            for (int nei : graph[node]) {
                dfs(nei, graph, path, result);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        int[][] graph = {{1,2},{3},{3},{}};

        System.out.println(allPathsSourceTarget(graph));
    }
}
