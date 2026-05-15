public class CircularKadaneMaximumSum {

    static int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currMax = 0;
        int maxSum = nums[0];

        int currMin = 0;
        int minSum = nums[0];

        for (int num : nums) {

            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            total += num;
        }

        // all numbers negative
        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {

        int[] nums = {5,-3,5};

        System.out.println(
                maxSubarraySumCircular(nums)
        );
    }
}
