import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(
            int[][] graph) {

        List<List<Integer>> result =
                new ArrayList<>();

        List<Integer> path =
                new ArrayList<>();

        path.add(0);

        dfs(
                0,
                graph,
                path,
                result
        );

        return result;
    }

    private void dfs(
            int node,
            int[][] graph,
            List<Integer> path,
            List<List<Integer>> result) {

        if (node == graph.length - 1) {

            result.add(
                    new ArrayList<>(path)
            );

            return;
        }

        for (int neighbor : graph[node]) {

            path.add(neighbor);

            dfs(
                    neighbor,
                    graph,
                    path,
                    result
            );

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        AllPathsSourceTarget solver =
                new AllPathsSourceTarget();

        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        List<List<Integer>> paths =
                solver.allPathsSourceTarget(graph);

        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
