import java.util.*;

public class TarjanSCC {

    static int time = 0;

    static void tarjan(int u, List<List<Integer>> graph,
                       int[] disc, int[] low,
                       boolean[] inStack, Stack<Integer> stack) {

        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;

        for (int v : graph.get(u)) {

            if (disc[v] == -1) {

                tarjan(v, graph, disc, low, inStack, stack);
                low[u] = Math.min(low[u], low[v]);

            } else if (inStack[v]) {

                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // Root of SCC
        if (low[u] == disc[u]) {

            while (true) {

                int node = stack.pop();
                inStack[node] = false;

                System.out.print(node + " ");

                if (node == u) break;
            }

            System.out.println();
        }
    }

    static void findSCC(int V, List<List<Integer>> graph) {

        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] inStack = new boolean[V];

        Arrays.fill(disc, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                tarjan(i, graph, disc, low, inStack, stack);
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

        findSCC(V, graph);
    }
          }
