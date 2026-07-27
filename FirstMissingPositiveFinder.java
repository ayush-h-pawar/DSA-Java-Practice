public class FirstMissingPositiveFinder {

    public int firstMissingPositive(
            int[] numbers) {

        int length = numbers.length;

        for (int index = 0;
             index < length;
             index++) {

            while (numbers[index] > 0
                    && numbers[index] <= length
                    && numbers[index]
                    != numbers[numbers[index] - 1]) {

                swap(
                        numbers,
                        index,
                        numbers[index] - 1
                );
            }
        }

        for (int index = 0;
             index < length;
             index++) {

            if (numbers[index]
                    != index + 1) {

                return index + 1;
            }
        }

        return length + 1;
    }

    private void swap(
            int[] numbers,
            int first,
            int second) {

        int temporary =
                numbers[first];

        numbers[first] =
                numbers[second];

        numbers[second] =
                temporary;
    }

    public static void main(String[] args) {

        FirstMissingPositiveFinder solver =
                new FirstMissingPositiveFinder();

        int[] numbers = {
                3,
                4,
                -1,
                1
        };

        System.out.println(
                solver.firstMissingPositive(
                        numbers
                )
        );
    }
}
