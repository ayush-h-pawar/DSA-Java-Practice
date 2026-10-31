public class FirstBadVersionFinder {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Placeholder for LeetCode's built-in API.
    private boolean isBadVersion(int version) {
        return false;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)
// LeetCode: 278 - First Bad Version
