import java.util.Arrays;

public class FindSpecialArrayValue {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int index = lowerBound(nums, x);
            int count = n - index;

            if (count == x) {
                return x;
            }
        }

        return -1;
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(log n) for sorting, depending on implementation
// LeetCode: 1608 - Special Array With X Elements Greater Than or Equal X
