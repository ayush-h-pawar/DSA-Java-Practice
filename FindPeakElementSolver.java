public class FindPeakElementSolver {

    public int findPeakElement(
            int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int middle =
                    left + (right - left) / 2;

            if (numbers[middle]
                    > numbers[middle + 1]) {

                right = middle;

            } else {

                left = middle + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        FindPeakElementSolver solver =
                new FindPeakElementSolver();

        int[] numbers = {
                1,
                2,
                3,
                1
        };

        System.out.println(
                solver.findPeakElement(
                        numbers
                )
        );
    }
}
