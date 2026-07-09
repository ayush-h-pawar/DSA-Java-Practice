import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(
            int[][] graph) {

        int n = graph.length;

        List<List<Integer>> reverseGraph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] outDegree =
                new int[n];

        for (int node = 0; node < n; node++) {

            outDegree[node] = graph[node].length;

            for (int neighbor : graph[node]) {

                reverseGraph
                        .get(neighbor)
                        .add(node);
            }
        }

        Queue<Integer> queue =
                new ArrayDeque<>();

        for (int node = 0; node < n; node++) {

            if (outDegree[node] == 0) {
                queue.offer(node);
            }
        }

        List<Integer> safeNodes =
                new ArrayList<>();

        while (!queue.isEmpty()) {

            int current =
                    queue.poll();

            safeNodes.add(current);

            for (int previous :
                    reverseGraph.get(current)) {

                outDegree[previous]--;

                if (outDegree[previous] == 0) {
                    queue.offer(previous);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }

    public static void main(String[] args) {

        FindEventualSafeStates solver =
                new FindEventualSafeStates();

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        System.out.println(
                solver.eventualSafeNodes(graph)
        );
    }
}
