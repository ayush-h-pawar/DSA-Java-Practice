import java.util.Arrays;

public class MinimumArrowsBurstBalloons1 {

    public int findMinArrowShots(
            int[][] balloons) {

        if (balloons.length == 0) {
            return 0;
        }

        Arrays.sort(
                balloons,
                (first, second) ->
                        Integer.compare(
                                first[1],
                                second[1]
                        )
        );

        int arrows = 1;

        long arrowPosition =
                balloons[0][1];

        for (int index = 1;
             index < balloons.length;
             index++) {

            if (balloons[index][0]
                    > arrowPosition) {

                arrows++;

                arrowPosition =
                        balloons[index][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {

        MinimumArrowsBurstBalloons solver =
                new MinimumArrowsBurstBalloons();

        int[][] balloons = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };

        System.out.println(
                solver.findMinArrowShots(
                        balloons
                )
        );
    }
}
