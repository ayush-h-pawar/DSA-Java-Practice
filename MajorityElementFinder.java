public class MajorityElementFinder {

    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 169 - Majority Element
