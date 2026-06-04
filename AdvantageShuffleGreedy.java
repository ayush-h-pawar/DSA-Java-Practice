import java.util.*;

public class AdvantageShuffleGreedy {

    static int[] advantageCount(
            int[] nums1,
            int[] nums2) {

        int n = nums1.length;

        Arrays.sort(nums1);

        int[][] indexed =
                new int[n][2];

        for (int i = 0; i < n; i++) {

            indexed[i][0] = nums2[i];
            indexed[i][1] = i;
        }

        Arrays.sort(indexed,
                (a, b) ->
                        b[0] - a[0]);

        int left = 0;
        int right = n - 1;

        int[] result =
                new int[n];

        for (int[] pair : indexed) {

            int value = pair[0];
            int index = pair[1];

            if (nums1[right] > value) {

                result[index] =
                        nums1[right--];

            } else {

                result[index] =
                        nums1[left++];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 =
                {2,7,11,15};

        int[] nums2 =
                {1,10,4,11};

        System.out.println(
                Arrays.toString(
                        advantageCount(
                                nums1,
                                nums2
                        )
                )
        );
    }
}
