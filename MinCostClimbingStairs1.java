public class MaximumSubarrayCircular1 {

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxEnding = 0;
        int maxSum = Integer.MIN_VALUE;

        int minEnding = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);

            totalSum += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
