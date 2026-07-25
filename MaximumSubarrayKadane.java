public class MaximumSubarrayKadane {

    public int maxSubArray(
            int[] numbers) {

        int currentSum =
                numbers[0];

        int maximumSum =
                numbers[0];

        for (int index = 1;
             index < numbers.length;
             index++) {

            currentSum =
                    Math.max(
                            numbers[index],
                            currentSum
                                    + numbers[index]
                    );

            maximumSum =
                    Math.max(
                            maximumSum,
                            currentSum
                    );
        }

        return maximumSum;
    }

    public static void main(String[] args) {

        MaximumSubarrayKadane solver =
                new MaximumSubarrayKadane();

        int[] numbers = {
                -2,
                1,
                -3,
                4,
                -1,
                2,
                1,
                -5,
                4
        };

        System.out.println(
                solver.maxSubArray(
                        numbers
                )
        );
    }
}
