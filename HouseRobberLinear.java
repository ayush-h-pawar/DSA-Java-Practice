public class HouseRobberLinear {

    public int rob(int[] nums) {
        int previousTwo = 0;
        int previousOne = 0;

        for (int money : nums) {
            int current = Math.max(
                    previousOne,
                    previousTwo + money
            );

            previousTwo = previousOne;
            previousOne = current;
        }

        return previousOne;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 198 - House Robber
