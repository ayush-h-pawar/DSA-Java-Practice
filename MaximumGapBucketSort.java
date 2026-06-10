import java.util.*;

public class MaximumGapBucketSort {

    static int maximumGap(int[] nums) {

        if (nums == null ||
            nums.length < 2) {

            return 0;
        }

        int min =
                Arrays.stream(nums)
                      .min()
                      .getAsInt();

        int max =
                Arrays.stream(nums)
                      .max()
                      .getAsInt();

        if (min == max)
            return 0;

        int n = nums.length;

        int bucketSize =
                Math.max(
                        1,
                        (max - min) / (n - 1)
                );

        int bucketCount =
                (max - min) /
                bucketSize + 1;

        int[] bucketMin =
                new int[bucketCount];

        int[] bucketMax =
                new int[bucketCount];

        Arrays.fill(
                bucketMin,
                Integer.MAX_VALUE
        );

        Arrays.fill(
                bucketMax,
                Integer.MIN_VALUE
        );

        for (int num : nums) {

            int idx =
                    (num - min) /
                    bucketSize;

            bucketMin[idx] =
                    Math.min(
                            bucketMin[idx],
                            num
                    );

            bucketMax[idx] =
                    Math.max(
                            bucketMax[idx],
                            num
                    );
        }

        int maxGap = 0;
        int prevMax = min;

        for (int i = 0;
             i < bucketCount;
             i++) {

            if (bucketMin[i] ==
                Integer.MAX_VALUE) {

                continue;
            }

            maxGap =
                    Math.max(
                            maxGap,
                            bucketMin[i]
                            - prevMax
                    );

            prevMax =
                    bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {

        int[] nums =
                {3,6,9,1};

        System.out.println(
                maximumGap(nums)
        );
    }
}
