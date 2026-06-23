import java.util.*;

public class SkylineProblemSolver1 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] building : buildings) {

            events.add(
                    new int[]{
                            building[0],
                            -building[2]
                    });

            events.add(
                    new int[]{
                            building[1],
                            building[2]
                    });
        }

        events.sort((a, b) -> {

            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        List<List<Integer>> skyline =
                new ArrayList<>();

        PriorityQueue<Integer> heights =
                new PriorityQueue<>(
                        Collections.reverseOrder()
                );

        heights.offer(0);

        int previousMax = 0;

        for (int[] event : events) {

            int x = event[0];
            int h = event[1];

            if (h < 0) {

                heights.offer(-h);

            } else {

                heights.remove(h);
            }

            int currentMax = heights.peek();

            if (currentMax != previousMax) {

                skyline.add(
                        Arrays.asList(
                                x,
                                currentMax
                        )
                );

                previousMax = currentMax;
            }
        }

        return skyline;
    }

    public static void main(String[] args) {

        SkylineProblemSolver solver =
                new SkylineProblemSolver();

        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };

        System.out.println(
                solver.getSkyline(buildings)
        );
    }
}
