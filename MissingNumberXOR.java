public class MissingNumberXOR {

    public int missingNumber(int[] nums) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 268 - Missing Number
