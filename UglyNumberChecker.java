public class UglyNumberChecker {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] factors = {2, 3, 5};

        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)
// LeetCode: 263 - Ugly Number
