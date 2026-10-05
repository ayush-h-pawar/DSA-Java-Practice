public class PowXNCalculator {

    public double myPow(double x, int n) {
        long exponent = n;

        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= x;
            }

            x *= x;
            exponent /= 2;
        }

        return result;
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)
// LeetCode: 50 - Pow(x, n)
