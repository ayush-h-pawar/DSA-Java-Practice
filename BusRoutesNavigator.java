import java.util.*;

public class BusRoutesNavigator {

    public int numBusesToDestination(
            int[][] routes,
            int source,
            int target) {

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes =
                new HashMap<>();

        for (int route = 0; route < routes.length; route++) {

            for (int stop : routes[route]) {

                stopToRoutes
                        .computeIfAbsent(
                                stop,
                                key -> new ArrayList<>())
                        .add(route);
            }
        }

        Queue<Integer> queue =
                new LinkedList<>();

        Set<Integer> visitedStops =
                new HashSet<>();

        boolean[] visitedRoutes =
                new boolean[routes.length];

        queue.offer(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            busesTaken++;

            while (size-- > 0) {

                int currentStop = queue.poll();

                List<Integer> busRoutes =
                        stopToRoutes.get(currentStop);

                if (busRoutes == null) {
                    continue;
                }

                for (int route : busRoutes) {

                    if (visitedRoutes[route]) {
                        continue;
                    }

                    visitedRoutes[route] = true;

                    for (int nextStop : routes[route]) {

                        if (nextStop == target) {
                            return busesTaken;
                        }

                        if (!visitedStops.contains(nextStop)) {

                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        BusRoutesNavigator solver =
                new BusRoutesNavigator();

        int[][] routes = {
                {1, 2, 7},
                {3, 6, 7}
        };

        System.out.println(
                solver.numBusesToDestination(
                        routes,
                        1,
                        6
                )
        );
    }
}
