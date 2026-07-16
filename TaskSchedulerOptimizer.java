import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerOptimizer {

    public int leastInterval(
            char[] tasks,
            int cooldown) {

        Map<Character, Integer> frequency =
                new HashMap<>();

        int maximumFrequency = 0;

        for (char task : tasks) {

            int count =
                    frequency.getOrDefault(
                            task,
                            0
                    ) + 1;

            frequency.put(task, count);

            maximumFrequency =
                    Math.max(
                            maximumFrequency,
                            count
                    );
        }

        int maximumCount = 0;

        for (int count : frequency.values()) {

            if (count == maximumFrequency) {
                maximumCount++;
            }
        }

        int minimumTime =
                (maximumFrequency - 1)
                        * (cooldown + 1)
                        + maximumCount;

        return Math.max(
                tasks.length,
                minimumTime
        );
    }

    public static void main(String[] args) {

        TaskSchedulerOptimizer solver =
                new TaskSchedulerOptimizer();

        char[] tasks = {
                'A',
                'A',
                'A',
                'B',
                'B',
                'B'
        };

        System.out.println(
                solver.leastInterval(
                        tasks,
                        2
                )
        );
    }
}
