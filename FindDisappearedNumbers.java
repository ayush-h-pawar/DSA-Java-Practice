import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark numbers that exist
        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Positive values represent missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        // Restore the array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1) excluding the result list
// LeetCode: 448 - Find All Numbers Disappeared in an Array
