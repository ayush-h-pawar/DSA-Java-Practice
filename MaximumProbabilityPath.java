import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumProbabilityPath {

    static class Edge {

        int destination;
        double probability;

        Edge(int destination, double probability) {
            this.destination = destination;
            this.probability = probability;
        }
    }

    static class State {

        int node;
        double probability;

        State(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    public double maxProbability(
            int n,
            int[][] edges,
            double[] successProbability,
            int start,
            int end) {

        List<List<Edge>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            double probability =
                    successProbability[i];

            graph.get(u).add(
                    new Edge(v, probability)
            );

            graph.get(v).add(
                    new Edge(u, probability)
            );
        }

        double[] bestProbability =
                new double[n];

        bestProbability[start] = 1.0;

        PriorityQueue<State> maxHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                Double.compare(
                                        b.probability,
                                        a.probability
                                )
                );

        maxHeap.offer(
                new State(
                        start,
                        1.0
                )
        );

        while (!maxHeap.isEmpty()) {

            State current =
                    maxHeap.poll();

            if (current.node == end) {
                return current.probability;
            }

            if (current.probability
                    < bestProbability[current.node]) {
                continue;
            }

            for (Edge edge :
                    graph.get(current.node)) {

                double newProbability =
                        current.probability
                                * edge.probability;

                if (newProbability
                        > bestProbability[edge.destination]) {

                    bestProbability[edge.destination] =
                            newProbability;

                    maxHeap.offer(
                            new State(
                                    edge.destination,
                                    newProbability
                            )
                    );
                }
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        MaximumProbabilityPath solver =
                new MaximumProbabilityPath();

        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] probabilities = {
                0.5,
                0.5,
                0.2
        };

        System.out.println(
                solver.maxProbability(
                        3,
                        edges,
                        probabilities,
                        0,
                        2
                )
        );
    }
}
