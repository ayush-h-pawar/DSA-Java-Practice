import java.util.PriorityQueue;
import java.util.Arrays;

public class KClosestPoints {

    static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {

            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] points = {{1,3}, {-2,2}, {5,8}};
        int k = 2;

        int[][] result = kClosest(points, k);

        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }
    }
}
