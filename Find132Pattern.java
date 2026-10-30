import java.util.ArrayDeque;
import java.util.Deque;

public class Find132Pattern {

    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int middle = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < middle) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                middle = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 456 - 132 Pattern
