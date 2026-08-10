import java.util.HashMap;
import java.util.Map;

public class UndergroundSystemTracker1 {

    static class CheckIn {

        String station;
        int time;

        CheckIn(
                String station,
                int time) {

            this.station = station;
            this.time = time;
        }
    }

    static class RouteStats {

        long totalTime;
        int trips;

        void addTrip(int duration) {
            totalTime += duration;
            trips++;
        }

        double averageTime() {
            return (double) totalTime / trips;
        }
    }

    private final Map<Integer, CheckIn> activeTrips =
            new HashMap<>();

    private final Map<String, RouteStats> routes =
            new HashMap<>();

    public void checkIn(
            int id,
            String stationName,
            int time) {

        activeTrips.put(
                id,
                new CheckIn(
                        stationName,
                        time
                )
        );
    }

    public void checkOut(
            int id,
            String stationName,
            int time) {

        CheckIn checkIn =
                activeTrips.remove(id);

        String route =
                checkIn.station
                        + "->"
                        + stationName;

        routes.putIfAbsent(
                route,
                new RouteStats()
        );

        routes.get(route)
                .addTrip(
                        time - checkIn.time
                );
    }

    public double getAverageTime(
            String startStation,
            String endStation) {

        String route =
                startStation
                        + "->"
                        + endStation;

        return routes.get(route)
                .averageTime();
    }

    public static void main(String[] args) {

        UndergroundSystemTracker system =
                new UndergroundSystemTracker();

        system.checkIn(
                45,
                "Leyton",
                3
        );

        system.checkIn(
                32,
                "Paradise",
                8
        );

        system.checkIn(
                27,
                "Leyton",
                10
        );

        system.checkOut(
                45,
                "Waterloo",
                15
        );

        system.checkOut(
                27,
                "Waterloo",
                20
        );

        System.out.println(
                system.getAverageTime(
                        "Leyton",
                        "Waterloo"
                )
        );
    }
}
