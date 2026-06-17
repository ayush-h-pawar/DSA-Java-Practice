public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] answer = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {

            int[] part1 = getMaxSubsequence(nums1, i);
            int[] part2 = getMaxSubsequence(nums2, k - i);

            int[] candidate = merge(part1, part2);

            if (greater(candidate, 0, answer, 0)) {
                answer = candidate;
            }
        }

        return answer;
    }

    private int[] getMaxSubsequence(int[] nums, int k) {

        int[] stack = new int[k];

        int top = -1;
        int remove = nums.length - k;

        for (int num : nums) {

            while (top >= 0 &&
                    stack[top] < num &&
                    remove > 0) {

                top--;
                remove--;
            }

            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                remove--;
            }
        }

        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {

        int[] merged =
                new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < nums1.length ||
                j < nums2.length) {

            if (greater(nums1, i, nums2, j)) {
                merged[index++] = nums1[i++];
            } else {
                merged[index++] = nums2[j++];
            }
        }

        return merged;
    }

    private boolean greater(
            int[] nums1,
            int i,
            int[] nums2,
            int j) {

        while (i < nums1.length &&
                j < nums2.length &&
                nums1[i] == nums2[j]) {

            i++;
            j++;
        }

        if (j == nums2.length) {
            return true;
        }

        if (i == nums1.length) {
            return false;
        }

        return nums1[i] > nums2[j];
    }

    public static void main(String[] args) {

        CreateMaximumNumber solver =
                new CreateMaximumNumber();

        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};

        int[] result =
                solver.maxNumber(nums1, nums2, 5);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
