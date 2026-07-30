public class MinimumSizeSubarraySum {

    public int minSubArrayLen(
            int target,
            int[] numbers) {

        int left = 0;
        int currentSum = 0;
        int minimumLength =
                Integer.MAX_VALUE;

        for (int right = 0;
             right < numbers.length;
             right++) {

            currentSum += numbers[right];

            while (currentSum >= target) {

                minimumLength =
                        Math.min(
                                minimumLength,
                                right - left + 1
                        );

                currentSum -= numbers[left];
                left++;
            }
        }

        return minimumLength
                == Integer.MAX_VALUE
                ? 0
                : minimumLength;
    }

    public static void main(String[] args) {

        MinimumSizeSubarraySum solver =
                new MinimumSizeSubarraySum();

        int[] numbers = {
                2,
                3,
                1,
                2,
                4,
                3
        };

        System.out.println(
                solver.minSubArrayLen(
                        7,
                        numbers
                )
        );
    }
}
