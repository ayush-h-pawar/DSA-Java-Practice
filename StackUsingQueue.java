import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {

    private final Queue<Integer> queue =
            new ArrayDeque<>();

    public void push(int value) {

        queue.offer(value);

        int size = queue.size();

        for (int index = 1;
             index < size;
             index++) {

            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        StackUsingQueue stack =
                new StackUsingQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
