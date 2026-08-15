public class HouseRobberCircular {

    public int rob(int[] houses) {

        if (houses.length == 1) {
            return houses[0];
        }

        int firstCase =
                robLinear(
                        houses,
                        0,
                        houses.length - 2
                );

        int secondCase =
                robLinear(
                        houses,
                        1,
                        houses.length - 1
                );

        return Math.max(
                firstCase,
                secondCase
        );
    }

    private int robLinear(
            int[] houses,
            int start,
            int end) {

        int previousTwo = 0;
        int previousOne = 0;

        for (int index = start;
             index <= end;
             index++) {

            int current =
                    Math.max(
                            previousOne,
                            previousTwo + houses[index]
                    );

            previousTwo =
                    previousOne;

            previousOne =
                    current;
        }

        return previousOne;
    }

    public static void main(String[] args) {

        HouseRobberCircular solver =
                new HouseRobberCircular();

        int[] houses = {
                2, 3, 2
        };

        System.out.println(
                solver.rob(houses)
        );
    }
}
