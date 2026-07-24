import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKSolver {

    public int subarraySum(
            int[] numbers,
            int target) {

        Map<Integer, Integer> prefixSumCount =
                new HashMap<>();

        prefixSumCount.put(0, 1);

        int prefixSum = 0;
        int totalSubarrays = 0;

        for (int number : numbers) {

            prefixSum += number;

            totalSubarrays +=
                    prefixSumCount.getOrDefault(
                            prefixSum - target,
                            0
                    );

            prefixSumCount.put(
                    prefixSum,
                    prefixSumCount.getOrDefault(
                            prefixSum,
                            0
                    ) + 1
            );
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {

        SubarraySumEqualsKSolver solver =
                new SubarraySumEqualsKSolver();

        int[] numbers = {
                1,
                1,
                1
        };

        System.out.println(
                solver.subarraySum(
                        numbers,
                        2
                )
        );
    }
}
