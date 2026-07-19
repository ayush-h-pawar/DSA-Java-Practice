public class GasStationCircuit {

    public int canCompleteCircuit(
            int[] gas,
            int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        int currentFuel = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            currentFuel += gas[i] - cost[i];

            if (currentFuel < 0) {

                startStation = i + 1;
                currentFuel = 0;
            }
        }

        if (totalGas < totalCost) {
            return -1;
        }

        return startStation;
    }

    public static void main(String[] args) {

        GasStationCircuit solver =
                new GasStationCircuit();

        int[] gas = {
                1,
                2,
                3,
                4,
                5
        };

        int[] cost = {
                3,
                4,
                5,
                1,
                2
        };

        System.out.println(
                solver.canCompleteCircuit(
                        gas,
                        cost
                )
        );
    }
}
