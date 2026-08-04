import java.util.PriorityQueue;

public class KthLargestArrayElement {

    public int findKthLargest(
            int[] numbers,
            int k) {

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        for (int number : numbers) {

            minHeap.offer(number);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        KthLargestArrayElement solver =
                new KthLargestArrayElement();

        int[] numbers = {
                3,
                2,
                1,
                5,
                6,
                4
        };

        System.out.println(
                solver.findKthLargest(
                        numbers,
                        2
                )
        );
    }
}
