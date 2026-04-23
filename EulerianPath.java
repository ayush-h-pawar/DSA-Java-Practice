import java.util.*;

public class EulerianPath {

    static List<Integer> findEulerianPath(int V, List<List<Integer>> graph) {

        int[] in = new int[V];
        int[] out = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                out[u]++;
                in[v]++;
            }
        }

        int start = 0, end = 0;

        for (int i = 0; i < V; i++) {

            if (out[i] - in[i] == 1) start = i;
            else if (in[i] - out[i] == 1) end = i;
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            int node = stack.peek();

            if (graph.get(node).size() > 0) {

                int next = graph.get(node).remove(0);
                stack.push(next);

            } else {

                path.add(stack.pop());
            }
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(0).add(3);

        System.out.println(findEulerianPath(V, graph));
    }
}
