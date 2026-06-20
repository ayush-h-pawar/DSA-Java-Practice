public class SplitArrayLargestSum1 {

    public int splitArray(int[] nums, int k) {

        long left = 0;
        long right = 0;

        for (int num : nums) {

            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {

            long mid =
                    left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private boolean canSplit(
            int[] nums,
            int k,
            long maxSum) {

        int partitions = 1;
        long currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {

                partitions++;
                currentSum = num;

                if (partitions > k) {
                    return false;
                }

            } else {

                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        SplitArrayLargestSum solver =
                new SplitArrayLargestSum();

        int[] nums = {7, 2, 5, 10, 8};

        System.out.println(
                solver.splitArray(nums, 2)
        );
    }
}
