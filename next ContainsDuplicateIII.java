import java.util.TreeSet;

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(
            int[] numbers,
            int indexDifference,
            int valueDifference) {

        TreeSet<Long> window =
                new TreeSet<>();

        for (int index = 0;
             index < numbers.length;
             index++) {

            Long candidate =
                    window.ceiling(
                            (long) numbers[index]
                                    - valueDifference
                    );

            if (candidate != null
                    && candidate
                    <= (long) numbers[index]
                    + valueDifference) {

                return true;
            }

            window.add(
                    (long) numbers[index]
            );

            if (index >= indexDifference) {

                window.remove(
                        (long) numbers[
                                index - indexDifference
                        ]
                );
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ContainsDuplicateIII solver =
                new ContainsDuplicateIII();

        int[] numbers = {
                1,
                2,
                3,
                1
        };

        System.out.println(
                solver.containsNearbyAlmostDuplicate(
                        numbers,
                        3,
                        0
                )
        );
    }
}
