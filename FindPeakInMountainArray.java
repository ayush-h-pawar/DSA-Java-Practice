public class FindPeakInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)
// LeetCode: 852 - Peak Index in a Mountain Array
