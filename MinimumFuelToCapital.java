import java.util.ArrayList;
import java.util.List;

public class MinimumFuelToCapital {

    private long fuelRequired;

    public long minimumFuelCost(
            int[][] roads,
            int seats) {

        int cities = roads.length + 1;

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < cities; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        fuelRequired = 0;

        dfs(
                0,
                -1,
                graph,
                seats
        );

        return fuelRequired;
    }

    private int dfs(
            int city,
            int parent,
            List<List<Integer>> graph,
            int seats) {

        int representatives = 1;

        for (int neighbor : graph.get(city)) {

            if (neighbor == parent) {
                continue;
            }

            representatives +=
                    dfs(
                            neighbor,
                            city,
                            graph,
                            seats
                    );
        }

        if (city != 0) {

            fuelRequired +=
                    (representatives + seats - 1)
                            / seats;
        }

        return representatives;
    }

    public static void main(String[] args) {

        MinimumFuelToCapital solver =
                new MinimumFuelToCapital();

        int[][] roads = {
                {0, 1},
                {0, 2},
                {0, 3}
        };

        System.out.println(
                solver.minimumFuelCost(
                        roads,
                        5
                )
        );
    }
}
