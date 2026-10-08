public class SingleNumberThreeState {

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 137 - Single Number II
