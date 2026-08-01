import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(
            int[] numbers,
            int goal) {

        Map<Integer, Integer> prefixCount =
                new HashMap<>();

        prefixCount.put(0, 1);

        int prefixSum = 0;
        int answer = 0;

        for (int number : numbers) {

            prefixSum += number;

            answer +=
                    prefixCount.getOrDefault(
                            prefixSum - goal,
                            0
                    );

            prefixCount.put(
                    prefixSum,
                    prefixCount.getOrDefault(
                            prefixSum,
                            0
                    ) + 1
            );
        }

        return answer;
    }

    public static void main(String[] args) {

        BinarySubarraysWithSum solver =
                new BinarySubarraysWithSum();

        int[] numbers = {
                1,
                0,
                1,
                0,
                1
        };

        System.out.println(
                solver.numSubarraysWithSum(
                        numbers,
                        2
                )
        );
    }
}
