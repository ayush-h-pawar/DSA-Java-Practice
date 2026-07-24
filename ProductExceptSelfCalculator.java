public class ProductExceptSelfCalculator {

    public int[] productExceptSelf(
            int[] numbers) {

        int length = numbers.length;

        int[] answer =
                new int[length];

        answer[0] = 1;

        for (int index = 1;
             index < length;
             index++) {

            answer[index] =
                    answer[index - 1]
                            * numbers[index - 1];
        }

        int suffixProduct = 1;

        for (int index = length - 1;
             index >= 0;
             index--) {

            answer[index] *= suffixProduct;

            suffixProduct *= numbers[index];
        }

        return answer;
    }

    public static void main(String[] args) {

        ProductExceptSelfCalculator solver =
                new ProductExceptSelfCalculator();

        int[] numbers = {
                1,
                2,
                3,
                4
        };

        int[] result =
                solver.productExceptSelf(
                        numbers
                );

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
