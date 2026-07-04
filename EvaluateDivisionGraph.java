import java.util.*;

public class EvaluateDivisionGraph {

    static class Edge {

        String neighbor;
        double weight;

        Edge(String neighbor, double weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, List<Edge>> graph =
                new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);

            graph
                    .computeIfAbsent(dividend,
                            k -> new ArrayList<>())
                    .add(new Edge(divisor, values[i]));

            graph
                    .computeIfAbsent(divisor,
                            k -> new ArrayList<>())
                    .add(new Edge(dividend, 1.0 / values[i]));
        }

        double[] answer =
                new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);

            if (!graph.containsKey(source)
                    || !graph.containsKey(destination)) {

                answer[i] = -1.0;

            } else if (source.equals(destination)) {

                answer[i] = 1.0;

            } else {

                answer[i] = dfs(
                        graph,
                        source,
                        destination,
                        1.0,
                        new HashSet<>()
                );
            }
        }

        return answer;
    }

    private double dfs(
            Map<String, List<Edge>> graph,
            String current,
            String target,
            double product,
            Set<String> visited) {

        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Edge edge : graph.get(current)) {

            if (!visited.contains(edge.neighbor)) {

                double result =
                        dfs(
                                graph,
                                edge.neighbor,
                                target,
                                product * edge.weight,
                                visited
                        );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {

        EvaluateDivisionGraph solver =
                new EvaluateDivisionGraph();

        List<List<String>> equations =
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("b", "c")
                );

        double[] values = {2.0, 3.0};

        List<List<String>> queries =
                Arrays.asList(
                        Arrays.asList("a", "c"),
                        Arrays.asList("b", "a"),
                        Arrays.asList("a", "e")
                );

        System.out.println(
                Arrays.toString(
                        solver.calcEquation(
                                equations,
                                values,
                                queries
                        )
                )
        );
    }
}
