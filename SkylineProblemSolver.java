import java.util.*;

public class SkylineProblemSolver {

    static List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {

            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }

        Collections.sort(events, (a, b) -> {

            if (a[0] != b[0])
                return a[0] - b[0];

            return a[1] - b[1];
        });

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(
                        Collections.reverseOrder()
                );

        maxHeap.offer(0);

        int prevMax = 0;

        List<List<Integer>> result =
                new ArrayList<>();

        for (int[] event : events) {

            int x = event[0];
            int h = event[1];

            if (h < 0) {

                maxHeap.offer(-h);

            } else {

                maxHeap.remove(h);
            }

            int currMax = maxHeap.peek();

            if (currMax != prevMax) {

                result.add(
                        Arrays.asList(x, currMax)
                );

                prevMax = currMax;
            }
        }

        return result;
    }
}
