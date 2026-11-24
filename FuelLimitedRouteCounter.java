public class FuelLimitedRouteCounter {

    private static final int MOD = 1_000_000_007;

    // Each city has a distinct position, so traveling always spends fuel.
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int cityCount = locations.length;
        int[][] routes = new int[fuel + 1][cityCount];

        for (int remaining = 0; remaining <= fuel; remaining++) {
            for (int city = 0; city < cityCount; city++) {
                int count = city == finish ? 1 : 0;
                for (int next = 0; next < cityCount; next++) {
                    long cost = Math.abs((long) locations[city] - locations[next]);
                    if (next != city && cost <= remaining) {
                        count += routes[remaining - (int) cost][next];
                        if (count >= MOD) {
                            count -= MOD;
                        }
                    }
                }
                routes[remaining][city] = count;
            }
        }
        return routes[fuel][start];
    }
}

// Time Complexity: O((fuel + 1) * n^2)
// Space Complexity: O((fuel + 1) * n)
