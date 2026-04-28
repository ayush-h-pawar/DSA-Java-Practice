public class ReversePairs {

    static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] nums, int left, int right) {

        if (left >= right) return 0;

        int mid = (left + right) / 2;

        int count = mergeSort(nums, left, mid)
                  + mergeSort(nums, mid + 1, right);

        // count reverse pairs
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right &&
                   (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += (j - (mid + 1));
        }

        merge(nums, left, mid, right);

        return count;
    }

    static void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }
}
