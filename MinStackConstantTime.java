import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackConstantTime {

    private final Deque<Integer> values =
            new ArrayDeque<>();

    private final Deque<Integer> minimums =
            new ArrayDeque<>();

    public void push(int value) {

        values.push(value);

        if (minimums.isEmpty()
                || value <= minimums.peek()) {

            minimums.push(value);
        }
    }

    public void pop() {

        int value =
                values.pop();

        if (value == minimums.peek()) {
            minimums.pop();
        }
    }

    public int top() {

        return values.peek();
    }

    public int getMin() {

        return minimums.peek();
    }

    public static void main(String[] args) {

        MinStackConstantTime stack =
                new MinStackConstantTime();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println(
                stack.getMin()
        );

        stack.pop();

        System.out.println(
                stack.top()
        );

        System.out.println(
                stack.getMin()
        );
    }
}
