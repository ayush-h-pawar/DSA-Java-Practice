import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperaturesMonotonicStack {

    public int[] dailyTemperatures(
            int[] temperatures) {

        int[] answer =
                new int[temperatures.length];

        Deque<Integer> stack =
                new ArrayDeque<>();

        for (int currentDay = 0;
             currentDay < temperatures.length;
             currentDay++) {

            while (!stack.isEmpty()
                    && temperatures[currentDay]
                    > temperatures[stack.peek()]) {

                int previousDay =
                        stack.pop();

                answer[previousDay] =
                        currentDay - previousDay;
            }

            stack.push(currentDay);
        }

        return answer;
    }

    public static void main(String[] args) {

        DailyTemperaturesMonotonicStack solver =
                new DailyTemperaturesMonotonicStack();

        int[] temperatures = {
                73, 74, 75, 71, 69, 72, 76, 73
        };

        int[] result =
                solver.dailyTemperatures(
                        temperatures
                );

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
