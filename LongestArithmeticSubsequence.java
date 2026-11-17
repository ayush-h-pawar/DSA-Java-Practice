import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int answer = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int difference = nums[i] - nums[j];

                int length = dp[j].getOrDefault(difference, 1) + 1;

                dp[i].put(difference, length);

                answer = Math.max(answer, length);
            }
        }

        return answer;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
