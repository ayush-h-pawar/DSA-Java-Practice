import java.util.*;

public class TopKFrequentElements {

    static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : freqMap.keySet()) {
            minHeap.offer(new int[]{key, freqMap.get(key)});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll()[0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] result = topKFrequent(nums, 2);

        for (int num : result)
            System.out.print(num + " ");
    }
}
