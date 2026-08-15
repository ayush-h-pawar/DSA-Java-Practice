import java.util.HashMap;
import java.util.Map;

public class TargetSumWays {

    public int findTargetSumWays(
            int[] numbers,
            int target) {

        Map<Integer, Integer> current =
                new HashMap<>();

        current.put(0, 1);

        for (int number : numbers) {

            Map<Integer, Integer> next =
                    new HashMap<>();

            for (Map.Entry<Integer, Integer> entry :
                    current.entrySet()) {

                int sum =
                        entry.getKey();

                int count =
                        entry.getValue();

                next.put(
                        sum + number,
                        next.getOrDefault(
                                sum + number,
                                0
                        ) + count
                );

                next.put(
                        sum - number,
                        next.getOrDefault(
                                sum - number,
                                0
                        ) + count
                );
            }

            current = next;
        }

        return current.getOrDefault(
                target,
                0
        );
    }

    public static void main(String[] args) {

        TargetSumWays solver =
                new TargetSumWays();

        int[] numbers = {
                1, 1, 1, 1, 1
        };

        System.out.println(
                solver.findTargetSumWays(
                        numbers,
                        3
                )
        );
    }
}
