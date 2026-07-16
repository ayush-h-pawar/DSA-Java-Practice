import java.util.Stack;

public class DailyTemperaturesSolver {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] answer = new int[n];

        Stack<Integer> stack =
                new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && temperatures[i]
                    > temperatures[stack.peek()]) {

                int index = stack.pop();

                answer[index] =
                        i - index;
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        DailyTemperaturesSolver solver =
                new DailyTemperaturesSolver();

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
