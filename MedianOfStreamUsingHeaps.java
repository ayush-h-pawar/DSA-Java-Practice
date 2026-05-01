import java.util.*;

public class MedianOfStreamUsingHeaps {

    PriorityQueue<Integer> maxHeap; // left (smaller half)
    PriorityQueue<Integer> minHeap; // right (larger half)

    public MedianOfStreamUsingHeaps() {

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianOfStreamUsingHeaps obj = new MedianOfStreamUsingHeaps();

        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian()); // 1.5

        obj.addNum(3);
        System.out.println(obj.findMedian()); // 2
    }
}
