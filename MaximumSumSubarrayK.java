public class MaximumSumSubarrayK {

    static int maxSum(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Sliding the window
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];      // add next element
            windowSum -= nums[i - k];  // remove previous element
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSum(nums, k));
    }
}
