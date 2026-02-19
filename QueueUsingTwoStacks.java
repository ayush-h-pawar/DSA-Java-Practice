import java.util.Stack;

public class QueueUsingTwoStacks {

    static class Queue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        void enqueue(int x) {
            stack1.push(x);
        }

        int dequeue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue Empty");
                return -1;
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
