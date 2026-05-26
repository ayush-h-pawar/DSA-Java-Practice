import java.util.*;

public class MedianFinderBalancedHeaps {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinderBalancedHeaps() {

        maxHeap = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() <
            minHeap.size()) {

            maxHeap.offer(
                    minHeap.poll()
            );
        }
    }

    public double findMedian() {

        if (maxHeap.size() >
            minHeap.size()) {

            return maxHeap.peek();
        }

        return (maxHeap.peek() +
                minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianFinderBalancedHeaps mf =
                new MedianFinderBalancedHeaps();

        mf.addNum(1);
        mf.addNum(2);

        System.out.println(
                mf.findMedian()
        );

        mf.addNum(3);

        System.out.println(
                mf.findMedian()
        );
    }
}
