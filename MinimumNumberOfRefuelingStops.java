import java.util.*;

public class MinimumNumberOfRefuelingStops {

    static int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int i = 0, stops = 0;

        while (fuel < target) {

            // Add all reachable stations
            while (i < stations.length && stations[i][0] <= fuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }

            // If no fuel available → impossible
            if (maxHeap.isEmpty())
                return -1;

            // Take the largest fuel
            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }

    public static void main(String[] args) {

        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10,60},{20,30},{30,30},{60,40}};

        System.out.println(minRefuelStops(target, startFuel, stations)); // 2
    }
}
