import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementCircular {

    public int[] nextGreaterElements(
            int[] numbers) {

        int n = numbers.length;

        int[] answer =
                new int[n];

        Arrays.fill(
                answer,
                -1
        );

        Deque<Integer> stack =
                new ArrayDeque<>();

        for (int index = 0;
             index < 2 * n;
             index++) {

            int currentIndex =
                    index % n;

            while (!stack.isEmpty()
                    && numbers[
                            stack.peek()
                    ] < numbers[currentIndex]) {

                answer[
                        stack.pop()
                ] = numbers[currentIndex];
            }

            if (index < n) {
                stack.push(currentIndex);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        NextGreaterElementCircular solver =
                new NextGreaterElementCircular();

        int[] numbers = {
                1,
                2,
                1
        };

        int[] result =
                solver.nextGreaterElements(
                        numbers
                );

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
