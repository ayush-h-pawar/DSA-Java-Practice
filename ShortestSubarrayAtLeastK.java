import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayAtLeastK {

    public int shortestSubarray(int[] nums, int k) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> candidates = new ArrayDeque<>();
        int shortest = nums.length + 1;

        for (int end = 0; end < prefix.length; end++) {
            while (!candidates.isEmpty() && prefix[end] - prefix[candidates.peekFirst()] >= k) {
                shortest = Math.min(shortest, end - candidates.removeFirst());
            }

            // The later start offers at least as much sum in every future window.
            while (!candidates.isEmpty() && prefix[candidates.peekLast()] >= prefix[end]) {
                candidates.removeLast();
            }
            candidates.addLast(end);
        }

        return shortest <= nums.length ? shortest : -1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
