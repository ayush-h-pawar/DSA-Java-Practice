public class FindDuplicateNumberCycle {

    public int findDuplicate(
            int[] numbers) {

        int slow =
                numbers[0];

        int fast =
                numbers[0];

        do {

            slow =
                    numbers[slow];

            fast =
                    numbers[
                            numbers[fast]
                    ];

        } while (slow != fast);

        slow = numbers[0];

        while (slow != fast) {

            slow =
                    numbers[slow];

            fast =
                    numbers[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        FindDuplicateNumberCycle solver =
                new FindDuplicateNumberCycle();

        int[] numbers = {
                1,
                3,
                4,
                2,
                2
        };

        System.out.println(
                solver.findDuplicate(
                        numbers
                )
        );
    }
}
