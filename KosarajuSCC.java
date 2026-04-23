import java.util.*;

public class KosarajuSCC {

    static void dfs1(int node, List<List<Integer>> graph,
                     boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei])
                dfs1(nei, graph, visited, stack);
        }

        stack.push(node);
    }

    static void dfs2(int node, List<List<Integer>> revGraph,
                     boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int nei : revGraph.get(node)) {
            if (!visited[nei])
                dfs2(nei, revGraph, visited);
        }
    }

    static void kosaraju(int V, List<List<Integer>> graph) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: fill stack by finish time
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs1(i, graph, visited, stack);
        }

        // Step 2: reverse graph
        List<List<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            revGraph.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int nei : graph.get(i)) {
                revGraph.get(nei).add(i);
            }
        }

        Arrays.fill(visited, false);

        // Step 3: process nodes in stack order
        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (!visited[node]) {
                dfs2(node, revGraph, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(4);

        kosaraju(V, graph);
    }
                  }
