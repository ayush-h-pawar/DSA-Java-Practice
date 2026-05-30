import java.util.*;

public class CampusBikesAssignment {

    static int[] assignBikes(
            int[][] workers,
            int[][] bikes) {

        List<int[]> pairs =
                new ArrayList<>();

        for (int i = 0;
             i < workers.length;
             i++) {

            for (int j = 0;
                 j < bikes.length;
                 j++) {

                int dist =
                        Math.abs(
                                workers[i][0] -
                                bikes[j][0]
                        )
                        +
                        Math.abs(
                                workers[i][1] -
                                bikes[j][1]
                        );

                pairs.add(
                        new int[]{
                                dist,
                                i,
                                j
                        }
                );
            }
        }

        pairs.sort((a, b) -> {

            if (a[0] != b[0])
                return a[0] - b[0];

            if (a[1] != b[1])
                return a[1] - b[1];

            return a[2] - b[2];
        });

        int[] result =
                new int[workers.length];

        Arrays.fill(result, -1);

        boolean[] usedBike =
                new boolean[bikes.length];

        for (int[] p : pairs) {

            int worker = p[1];
            int bike = p[2];

            if (result[worker] == -1 &&
                !usedBike[bike]) {

                result[worker] = bike;
                usedBike[bike] = true;
            }
        }

        return result;
    }
}
