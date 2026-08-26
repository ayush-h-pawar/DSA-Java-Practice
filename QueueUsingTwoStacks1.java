import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingTwoStacks1 {

    private final Deque<Integer> input =
            new ArrayDeque<>();

    private final Deque<Integer> output =
            new ArrayDeque<>();

    public void push(int value) {
        input.push(value);
    }

    public int pop() {
        moveElements();
        return output.pop();
    }

    public int peek() {
        moveElements();
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty()
                && output.isEmpty();
    }

    private void moveElements() {

        if (output.isEmpty()) {

            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {

        QueueUsingTwoStacks queue =
                new QueueUsingTwoStacks();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
