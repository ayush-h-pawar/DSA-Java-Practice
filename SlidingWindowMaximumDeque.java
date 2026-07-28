import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximumDeque {

    public int[] maxSlidingWindow(
            int[] numbers,
            int windowSize) {

        if (numbers == null
                || numbers.length == 0
                || windowSize == 0) {

            return new int[0];
        }

        int[] answer =
                new int[
                        numbers.length
                                - windowSize
                                + 1
                ];

        Deque<Integer> deque =
                new ArrayDeque<>();

        int resultIndex = 0;

        for (int index = 0;
             index < numbers.length;
             index++) {

            while (!deque.isEmpty()
                    && deque.peekFirst()
                    <= index - windowSize) {

                deque.pollFirst();
            }

            while (!deque.isEmpty()
                    && numbers[deque.peekLast()]
                    <= numbers[index]) {

                deque.pollLast();
            }

            deque.offerLast(index);

            if (index >= windowSize - 1) {

                answer[resultIndex++] =
                        numbers[
                                deque.peekFirst()
                        ];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        SlidingWindowMaximumDeque solver =
                new SlidingWindowMaximumDeque();

        int[] numbers = {
                1,
                3,
                -1,
                -3,
                5,
                3,
                6,
                7
        };

        int[] result =
                solver.maxSlidingWindow(
                        numbers,
                        3
                );

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
