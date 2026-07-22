import java.util.PriorityQueue;

public class KClosestPointsFinder {

    public int[][] kClosest(
            int[][] points,
            int k) {

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                        (first, second) ->
                                distance(second)
                                        - distance(first)
                );

        for (int[] point : points) {

            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] answer =
                new int[k][2];

        for (int i = k - 1; i >= 0; i--) {

            answer[i] = maxHeap.poll();
        }

        return answer;
    }

    private int distance(
            int[] point) {

        return point[0] * point[0]
                + point[1] * point[1];
    }

    public static void main(String[] args) {

        KClosestPointsFinder solver =
                new KClosestPointsFinder();

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int[][] result =
                solver.kClosest(
                        points,
                        2
                );

        for (int[] point : result) {

            System.out.println(
                    "[" + point[0]
                            + ", "
                            + point[1]
                            + "]"
            );
        }
    }
}
