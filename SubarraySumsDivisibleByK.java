public class SubarraySumsDivisibleByK {

    // The divisor is positive.
    public int subarraysDivByK(int[] nums, int k) {
        int[] frequency = new int[k];
        frequency[0] = 1;
        long remainder = 0;
        int count = 0;

        for (int value : nums) {
            remainder = Math.floorMod(remainder + value, k);
            int index = (int) remainder;
            // Equal prefix remainders delimit a subarray with sum divisible by k.
            count += frequency[index];
            frequency[index]++;
        }
        return count;
    }
}

// Time Complexity: O(n + k)
// Space Complexity: O(k)
