import java.util.Arrays;

public class FindPairWithTargetDifference {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        int count = 0;

        while (right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                count++;

                int currentLeft = nums[left];
                int currentRight = nums[right];

                while (left < nums.length && nums[left] == currentLeft) {
                    left++;
                }

                while (right < nums.length && nums[right] == currentRight) {
                    right++;
                }
            }
        }

        return count;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(1) auxiliary space
