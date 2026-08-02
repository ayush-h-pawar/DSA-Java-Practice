public class SearchRotatedSortedArrayII {

    public boolean search(
            int[] numbers,
            int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {

            int middle =
                    left + (right - left) / 2;

            if (numbers[middle] == target) {
                return true;
            }

            if (numbers[left]
                    == numbers[middle]
                    && numbers[middle]
                    == numbers[right]) {

                left++;
                right--;

            } else if (numbers[left]
                    <= numbers[middle]) {

                if (target >= numbers[left]
                        && target < numbers[middle]) {

                    right = middle - 1;

                } else {

                    left = middle + 1;
                }

            } else {

                if (target > numbers[middle]
                        && target <= numbers[right]) {

                    left = middle + 1;

                } else {

                    right = middle - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        SearchRotatedSortedArrayII solver =
                new SearchRotatedSortedArrayII();

        int[] numbers = {
                2,
                5,
                6,
                0,
                0,
                1,
                2
        };

        System.out.println(
                solver.search(
                        numbers,
                        0
                )
        );
    }
}
