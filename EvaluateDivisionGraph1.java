import java.util.*;

public class EvaluateDivisionGraph1 {

    static class Edge {

        String destination;
        double value;

        Edge(String destination, double value) {
            this.destination = destination;
            this.value = value;
        }
    }

    private final Map<String, List<Edge>> graph =
            new HashMap<>();

    public void addEquation(
            String first,
            String second,
            double value) {

        graph.computeIfAbsent(
                first,
                key -> new ArrayList<>()
        ).add(
                new Edge(second, value)
        );

        graph.computeIfAbsent(
                second,
                key -> new ArrayList<>()
        ).add(
                new Edge(first, 1.0 / value)
        );
    }

    public double evaluate(
            String start,
            String target) {

        if (!graph.containsKey(start)
                || !graph.containsKey(target)) {

            return -1.0;
        }

        if (start.equals(target)) {
            return 1.0;
        }

        Set<String> visited =
                new HashSet<>();

        return dfs(
                start,
                target,
                1.0,
                visited
        );
    }

    private double dfs(
            String current,
            String target,
            double product,
            Set<String> visited) {

        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Edge edge :
                graph.get(current)) {

            if (visited.contains(
                    edge.destination)) {
                continue;
            }

            double result =
                    dfs(
                            edge.destination,
                            target,
                            product * edge.value,
                            visited
                    );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {

        EvaluateDivisionGraph solver =
                new EvaluateDivisionGraph();

        solver.addEquation(
                "a",
                "b",
                2.0
        );

        solver.addEquation(
                "b",
                "c",
                3.0
        );

        System.out.println(
                solver.evaluate("a", "c")
        );

        System.out.println(
                solver.evaluate("b", "a")
        );

        System.out.println(
                solver.evaluate("a", "x")
        );
    }
}
