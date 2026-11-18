import java.util.Arrays;

public class MaximumFrequencyAfterIncrements {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        long windowSum = 0;
        int maxFrequency = 1;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while ((long) nums[right] * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(
                maxFrequency,
                right - left + 1
            );
        }

        return maxFrequency;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(1) auxiliary space
