public class MaximumProductSubarray1 {

    public int maxProduct(
            int[] numbers) {

        int maximumProduct =
                numbers[0];

        int currentMaximum =
                numbers[0];

        int currentMinimum =
                numbers[0];

        for (int index = 1;
             index < numbers.length;
             index++) {

            if (numbers[index] < 0) {

                int temporary =
                        currentMaximum;

                currentMaximum =
                        currentMinimum;

                currentMinimum =
                        temporary;
            }

            currentMaximum =
                    Math.max(
                            numbers[index],
                            currentMaximum
                                    * numbers[index]
                    );

            currentMinimum =
                    Math.min(
                            numbers[index],
                            currentMinimum
                                    * numbers[index]
                    );

            maximumProduct =
                    Math.max(
                            maximumProduct,
                            currentMaximum
                    );
        }

        return maximumProduct;
    }

    public static void main(String[] args) {

        MaximumProductSubarray solver =
                new MaximumProductSubarray();

        int[] numbers = {
                2,
                3,
                -2,
                4
        };

        System.out.println(
                solver.maxProduct(
                        numbers
                )
        );
    }
}
