import java.util.*;

public class EvaluateDivision {

    static double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(src, dst, graph, new HashSet<>());
            }
        }

        return result;
    }

    static double dfs(String curr, String target,
                      Map<String, Map<String, Double>> graph,
                      Set<String> visited) {

        if (curr.equals(target)) return 1.0;

        visited.add(curr);

        for (String nei : graph.get(curr).keySet()) {

            if (!visited.contains(nei)) {

                double res = dfs(nei, target, graph, visited);

                if (res != -1.0)
                    return res * graph.get(curr).get(nei);
            }
        }

        return -1.0;
    }
}
