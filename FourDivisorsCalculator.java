public class FourDivisorsCalculator {

    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            int divisorSum = 1 + num;
            int divisorCount = 2;
            boolean valid = true;

            for (int d = 2; d * d <= num; d++) {
                if (num % d == 0) {
                    int other = num / d;

                    if (d == other) {
                        divisorCount++;
                        divisorSum += d;
                    } else {
                        divisorCount += 2;
                        divisorSum += d + other;
                    }

                    if (divisorCount > 4) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid && divisorCount == 4) {
                totalSum += divisorSum;
            }
        }

        return totalSum;
    }
}

// Time Complexity: O(n * sqrt(M)), where M is the maximum number
// Space Complexity: O(1)
// LeetCode: 1390 - Four Divisors
