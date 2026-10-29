public class PerfectNumberChecker {

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                sum += i;

                int otherDivisor = num / i;

                if (otherDivisor != i) {
                    sum += otherDivisor;
                }
            }

            if (sum > num) {
                return false;
            }
        }

        return sum == num;
    }
}

// Time Complexity: O(√n)
// Space Complexity: O(1)
// LeetCode: 507 - Perfect Number
