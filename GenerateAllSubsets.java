import java.util.*;

public class GenerateAllSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        generate(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void generate(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);

            generate(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}

// Time Complexity: O(n * 2^n)
// Space Complexity: O(n) excluding output
// LeetCode: 78 - Subsets
