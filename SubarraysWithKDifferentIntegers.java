import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(
            int[] numbers,
            int k) {

        return countAtMost(numbers, k)
                - countAtMost(numbers, k - 1);
    }

    private int countAtMost(
            int[] numbers,
            int k) {

        Map<Integer, Integer> frequency =
                new HashMap<>();

        int left = 0;
        int answer = 0;

        for (int right = 0;
             right < numbers.length;
             right++) {

            frequency.put(
                    numbers[right],
                    frequency.getOrDefault(
                            numbers[right],
                            0
                    ) + 1
            );

            while (frequency.size() > k) {

                frequency.put(
                        numbers[left],
                        frequency.get(numbers[left]) - 1
                );

                if (frequency.get(numbers[left]) == 0) {
                    frequency.remove(numbers[left]);
                }

                left++;
            }

            answer += right - left + 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        SubarraysWithKDifferentIntegers solver =
                new SubarraysWithKDifferentIntegers();

        int[] numbers = {
                1,
                2,
                1,
                2,
                3
        };

        System.out.println(
                solver.subarraysWithKDistinct(
                        numbers,
                        2
                )
        );
    }
}
