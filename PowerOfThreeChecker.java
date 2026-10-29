public class PowerOfThreeChecker {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}

// Time Complexity: O(log₃ n)
// Space Complexity: O(1)
// LeetCode: 326 - Power of Three
