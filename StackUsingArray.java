public class StackUsingArray {

    static class Stack {
        int[] arr;
        int top;
        int capacity;

        Stack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        void push(int value) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = value;
        }

        int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }

        int peek() {
            if (top == -1) {
                System.out.println("Stack Empty");
                return -1;
            }
            return arr[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
