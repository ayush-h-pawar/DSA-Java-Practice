public class SingleNumberXOR {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 136 - Single Number
