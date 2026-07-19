import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffleOptimizer {

    public int[] advantageCount(
            int[] nums1,
            int[] nums2) {

        Arrays.sort(nums1);

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                        (a, b) ->
                                b[0] - a[0]
                );

        for (int i = 0; i < nums2.length; i++) {

            maxHeap.offer(
                    new int[]{
                            nums2[i],
                            i
                    }
            );
        }

        int left = 0;
        int right = nums1.length - 1;

        int[] answer =
                new int[nums1.length];

        while (!maxHeap.isEmpty()) {

            int[] current =
                    maxHeap.poll();

            int value = current[0];
            int index = current[1];

            if (nums1[right] > value) {

                answer[index] =
                        nums1[right--];

            } else {

                answer[index] =
                        nums1[left++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        AdvantageShuffleOptimizer solver =
                new AdvantageShuffleOptimizer();

        int[] nums1 = {
                2, 7, 11, 15
        };

        int[] nums2 = {
                1, 10, 4, 11
        };

        int[] result =
                solver.advantageCount(
                        nums1,
                        nums2
                );

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
