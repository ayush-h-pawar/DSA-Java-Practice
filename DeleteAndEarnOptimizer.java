public class DeleteAndEarnOptimizer {

    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        for (int num : nums) {
            points[num] += num;
        }

        int take = 0;
        int skip = 0;

        for (int point : points) {
            int newTake = skip + point;
            int newSkip = Math.max(take, skip);

            take = newTake;
            skip = newSkip;
        }

        return Math.max(take, skip);
    }
}

// Time Complexity: O(n + max(nums))
// Space Complexity: O(max(nums))
