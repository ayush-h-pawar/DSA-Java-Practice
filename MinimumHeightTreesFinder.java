import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTreesFinder {

    public List<Integer> findMinHeightTrees(
            int n,
            int[][] edges) {

        List<Integer> answer =
                new ArrayList<>();

        if (n == 1) {

            answer.add(0);
            return answer;
        }

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree =
                new int[n];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> leaves =
                new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {

            int size = leaves.size();

            remainingNodes -= size;

            while (size-- > 0) {

                int leaf = leaves.poll();

                for (int neighbor :
                        graph.get(leaf)) {

                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        while (!leaves.isEmpty()) {
            answer.add(leaves.poll());
        }

        return answer;
    }

    public static void main(String[] args) {

        MinimumHeightTreesFinder solver =
                new MinimumHeightTreesFinder();

        int[][] edges = {
                {1, 0},
                {1, 2},
                {1, 3}
        };

        System.out.println(
                solver.findMinHeightTrees(
                        4,
                        edges
                )
        );
    }
}
