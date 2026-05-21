import java.util.*;

public class UndergroundSystemTracker {

    static class CheckInData {

        String stationName;
        int time;

        CheckInData(String stationName,
                    int time) {

            this.stationName = stationName;
            this.time = time;
        }
    }

    static class RouteData {

        int totalTime;
        int tripCount;

        RouteData(int totalTime,
                  int tripCount) {

            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    Map<Integer, CheckInData> checkInMap;

    Map<String, RouteData> routeMap;

    public UndergroundSystemTracker() {

        checkInMap = new HashMap<>();

        routeMap = new HashMap<>();
    }

    public void checkIn(int id,
                        String stationName,
                        int t) {

        checkInMap.put(
                id,
                new CheckInData(
                        stationName,
                        t
                )
        );
    }

    public void checkOut(int id,
                         String stationName,
                         int t) {

        CheckInData checkIn =
                checkInMap.get(id);

        String route =
                checkIn.stationName +
                "->" +
                stationName;

        int travelTime =
                t - checkIn.time;

        RouteData data =
                routeMap.getOrDefault(
                        route,
                        new RouteData(0, 0)
                );

        data.totalTime += travelTime;
        data.tripCount++;

        routeMap.put(route, data);

        checkInMap.remove(id);
    }

    public double getAverageTime(
            String startStation,
            String endStation) {

        String route =
                startStation +
                "->" +
                endStation;

        RouteData data =
                routeMap.get(route);

        return (double)
                data.totalTime /
                data.tripCount;
    }

    public static void main(String[] args) {

        UndergroundSystemTracker system =
                new UndergroundSystemTracker();

        system.checkIn(1,
                "A", 3);

        system.checkOut(1,
                "B", 15);

        System.out.println(
                system.getAverageTime(
                        "A", "B"
                )
        );
    }
    }
