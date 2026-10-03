public class MoveZeroesInArray {

    public void moveZeroes(int[] nums) {
        int position = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[position] = num;
                position++;
            }
        }

        while (position < nums.length) {
            nums[position] = 0;
            position++;
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 283 - Move Zeroes
