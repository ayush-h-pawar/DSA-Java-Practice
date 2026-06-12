import java.util.*;

public class FindMedianFromDataStreamAdvanced {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStreamAdvanced() {

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

        FindMedianFromDataStreamAdvanced mf =
                new FindMedianFromDataStreamAdvanced();

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
