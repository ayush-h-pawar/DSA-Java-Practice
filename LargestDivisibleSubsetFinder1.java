import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubsetFinder1 {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        int maxLength = 1;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {

            parent[i] = i;

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0
                        && dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        while (parent[maxIndex] != maxIndex) {

            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        result.add(nums[maxIndex]);

        return result;
    }

    public static void main(String[] args) {

        LargestDivisibleSubsetFinder solver =
                new LargestDivisibleSubsetFinder();

        int[] nums = {1, 2, 4, 8};

        System.out.println(
                solver.largestDivisibleSubset(nums)
        );
    }
}
