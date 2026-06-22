import java.util.*;

public class ReconstructItineraryEuler {

    private final Map<String,
            PriorityQueue<String>> graph =
            new HashMap<>();

    private final LinkedList<String> itinerary =
            new LinkedList<>();

    public List<String> findItinerary(
            List<List<String>> tickets) {

        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            graph
                    .computeIfAbsent(
                            from,
                            k -> new PriorityQueue<>())
                    .offer(to);
        }

        dfs("JFK");

        return itinerary;
    }

    private void dfs(String airport) {

        PriorityQueue<String> destinations =
                graph.get(airport);

        while (destinations != null
                && !destinations.isEmpty()) {

            dfs(destinations.poll());
        }

        itinerary.addFirst(airport);
    }

    public static void main(String[] args) {

        ReconstructItineraryEuler solver =
                new ReconstructItineraryEuler();

        List<List<String>> tickets =
                new ArrayList<>();

        tickets.add(
                Arrays.asList("MUC", "LHR"));
        tickets.add(
                Arrays.asList("JFK", "MUC"));
        tickets.add(
                Arrays.asList("SFO", "SJC"));
        tickets.add(
                Arrays.asList("LHR", "SFO"));

        System.out.println(
                solver.findItinerary(tickets)
        );
    }
}
