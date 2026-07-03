import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTimeSolver {

    static class Edge {

        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node {

        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public int networkDelayTime(
            int[][] times,
            int n,
            int source) {

        List<List<Edge>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {

            graph.get(edge[0]).add(
                    new Edge(
                            edge[1],
                            edge[2]
                    )
            );
        }

        int[] distance =
                new int[n + 1];

        Arrays.fill(
                distance,
                Integer.MAX_VALUE
        );

        distance[source] = 0;

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                a.distance - b.distance
                );

        minHeap.offer(
                new Node(source, 0)
        );

        while (!minHeap.isEmpty()) {

            Node current =
                    minHeap.poll();

            if (current.distance >
                    distance[current.vertex]) {
                continue;
            }

            for (Edge edge :
                    graph.get(current.vertex)) {

                int newDistance =
                        current.distance
                                + edge.weight;

                if (newDistance
                        < distance[edge.destination]) {

                    distance[edge.destination] =
                            newDistance;

                    minHeap.offer(
                            new Node(
                                    edge.destination,
                                    newDistance
                            )
                    );
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i]
                    == Integer.MAX_VALUE) {
                return -1;
            }

            answer =
                    Math.max(
                            answer,
                            distance[i]
                    );
        }

        return answer;
    }

    public static void main(String[] args) {

        NetworkDelayTimeSolver solver =
                new NetworkDelayTimeSolver();

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        System.out.println(
                solver.networkDelayTime(
                        times,
                        4,
                        2
                )
        );
    }
}
