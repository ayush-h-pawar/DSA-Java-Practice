public class MaximumAverageSubarrayFinder {

    public double findMaxAverage(
            int[] numbers,
            int windowSize) {

        int currentSum = 0;

        for (int index = 0;
             index < windowSize;
             index++) {

            currentSum += numbers[index];
        }

        int maximumSum = currentSum;

        for (int index = windowSize;
             index < numbers.length;
             index++) {

            currentSum += numbers[index];
            currentSum -= numbers[index - windowSize];

            maximumSum =
                    Math.max(
                            maximumSum,
                            currentSum
                    );
        }

        return (double) maximumSum
                / windowSize;
    }

    public static void main(String[] args) {

        MaximumAverageSubarrayFinder solver =
                new MaximumAverageSubarrayFinder();

        int[] numbers = {
                1,
                12,
                -5,
                -6,
                50,
                3
        };

        System.out.println(
                solver.findMaxAverage(
                        numbers,
                        4
                )
        );
    }
}
