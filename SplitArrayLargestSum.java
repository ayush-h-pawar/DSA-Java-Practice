public class SplitArrayLargestSum {

    static int splitArray(int[] nums,
                          int k) {

        int left = 0;
        int right = 0;

        for (int num : nums) {

            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {

            int mid =
                    left +
                    (right - left) / 2;

            if (canSplit(nums,
                         k,
                         mid)) {

                right = mid;

            } else {

                left = mid + 1;
            }
        }

        return left;
    }

    static boolean canSplit(int[] nums,
                            int k,
                            int maxSum) {

        int count = 1;
        int currSum = 0;

        for (int num : nums) {

            if (currSum + num > maxSum) {

                count++;
                currSum = num;

            } else {

                currSum += num;
            }
        }

        return count <= k;
    }

    public static void main(String[] args) {

        int[] nums = {7,2,5,10,8};

        System.out.println(
                splitArray(nums, 2)
        );
    }
}
