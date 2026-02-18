public class QueueUsingArray {

    static class Queue {
        int[] arr;
        int front;
        int rear;
        int capacity;

        Queue(int size) {
            arr = new int[size];
            capacity = size;
            front = 0;
            rear = -1;
        }

        void enqueue(int value) {
            if (rear == capacity - 1) {
                System.out.println("Queue Overflow");
                return;
            }
            arr[++rear] = value;
        }

        int dequeue() {
            if (front > rear) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return arr[front++];
        }

        boolean isEmpty() {
            return front > rear;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
