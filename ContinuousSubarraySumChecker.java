import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumChecker {

    public boolean checkSubarraySum(
            int[] numbers,
            int k) {

        Map<Integer, Integer> remainderIndex =
                new HashMap<>();

        remainderIndex.put(0, -1);

        int prefixSum = 0;

        for (int index = 0;
             index < numbers.length;
             index++) {

            prefixSum += numbers[index];

            int remainder =
                    k == 0
                            ? prefixSum
                            : prefixSum % k;

            if (remainderIndex.containsKey(remainder)) {

                if (index
                        - remainderIndex.get(remainder)
                        >= 2) {

                    return true;
                }

            } else {

                remainderIndex.put(
                        remainder,
                        index
                );
            }
        }

        return false;
    }

    public static void main(String[] args) {

        ContinuousSubarraySumChecker solver =
                new ContinuousSubarraySumChecker();

        int[] numbers = {
                23,
                2,
                4,
                6,
                7
        };

        System.out.println(
                solver.checkSubarraySum(
                        numbers,
                        6
                )
        );
    }
}
