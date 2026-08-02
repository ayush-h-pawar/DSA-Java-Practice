public class SingleElementSortedArray {

    public int singleNonDuplicate(
            int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int middle =
                    left + (right - left) / 2;

            if (middle % 2 == 1) {
                middle--;
            }

            if (numbers[middle]
                    == numbers[middle + 1]) {

                left = middle + 2;

            } else {

                right = middle;
            }
        }

        return numbers[left];
    }

    public static void main(String[] args) {

        SingleElementSortedArray solver =
                new SingleElementSortedArray();

        int[] numbers = {
                1,
                1,
                2,
                3,
                3,
                4,
                4,
                8,
                8
        };

        System.out.println(
                solver.singleNonDuplicate(
                        numbers
                )
        );
    }
}
