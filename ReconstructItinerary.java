import java.util.*;

public class ReconstructItinerary {

    static List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> t : tickets) {
            graph.computeIfAbsent(t.get(0), k -> new PriorityQueue<>())
                 .offer(t.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", graph, result);

        return result;
    }

    static void dfs(String airport,
                    Map<String, PriorityQueue<String>> graph,
                    LinkedList<String> result) {

        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, graph, result);
        }

        result.addFirst(airport);
    }

    public static void main(String[] args) {

        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("MUC","LHR"),
                Arrays.asList("JFK","MUC"),
                Arrays.asList("SFO","SJC"),
                Arrays.asList("LHR","SFO")
        );

        System.out.println(findItinerary(tickets));
    }
}
