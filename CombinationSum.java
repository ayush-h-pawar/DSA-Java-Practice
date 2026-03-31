import java.util.*;

public class CombinationSum {

    static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int start, int[] nums, int target,
                          List<Integer> current,
                          List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0)
            return;

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);
            backtrack(i, nums, target - nums[i], current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(nums, target));
    }
}
