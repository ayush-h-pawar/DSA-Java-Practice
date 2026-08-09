public class DesignCircularDeque {

    private final int[] deque;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public DesignCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        deque[rear] = value;
        rear = (rear + 1) % capacity;
        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;

        return deque[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        DesignCircularDeque deque =
                new DesignCircularDeque(3);

        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));

        System.out.println(deque.getRear());
        System.out.println(deque.getFront());

        deque.deleteLast();

        System.out.println(deque.getRear());
    }
}
