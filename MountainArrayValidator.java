public class MountainArrayValidator {

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // Move upward
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be the first or last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Move downward
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 941 - Valid Mountain Array
