import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops1 {

    static class Edge {

        int destination;
        int price;

        Edge(int destination, int price) {
            this.destination = destination;
            this.price = price;
        }
    }

    static class State {

        int city;
        int cost;
        int stops;

        State(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int source,
            int destination,
            int maxStops) {

        List<List<Edge>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {

            graph.get(flight[0]).add(
                    new Edge(
                            flight[1],
                            flight[2]
                    )
            );
        }

        int[][] distance =
                new int[n][maxStops + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(
                    distance[i],
                    Integer.MAX_VALUE
            );
        }

        PriorityQueue<State> minHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                a.cost - b.cost
                );

        minHeap.offer(
                new State(
                        source,
                        0,
                        0
                )
        );

        distance[source][0] = 0;

        while (!minHeap.isEmpty()) {

            State current =
                    minHeap.poll();

            if (current.city == destination) {
                return current.cost;
            }

            if (current.stops
                    > maxStops) {
                continue;
            }

            for (Edge edge :
                    graph.get(current.city)) {

                int nextCost =
                        current.cost
                                + edge.price;

                if (nextCost
                        < distance[edge.destination]
                        [current.stops + 1]) {

                    distance[edge.destination]
                            [current.stops + 1]
                            = nextCost;

                    minHeap.offer(
                            new State(
                                    edge.destination,
                                    nextCost,
                                    current.stops + 1
                            )
                    );
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        CheapestFlightsWithinKStops solver =
                new CheapestFlightsWithinKStops();

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        System.out.println(
                solver.findCheapestPrice(
                        3,
                        flights,
                        0,
                        2,
                        1
                )
        );
    }
}
