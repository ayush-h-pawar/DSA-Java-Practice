import java.util.Collections;
import java.util.PriorityQueue;

public class MedianDataStreamFinder1 {

    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianDataStreamFinder() {

        maxHeap =
                new PriorityQueue<>(
                        Collections.reverseOrder()
                );

        minHeap =
                new PriorityQueue<>();
    }

    public void addNumber(int number) {

        maxHeap.offer(number);

        minHeap.offer(maxHeap.poll());

        if (minHeap.size()
                > maxHeap.size()) {

            maxHeap.offer(
                    minHeap.poll()
            );
        }
    }

    public double findMedian() {

        if (maxHeap.size()
                > minHeap.size()) {

            return maxHeap.peek();
        }

        return (maxHeap.peek()
                + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianDataStreamFinder finder =
                new MedianDataStreamFinder();

        finder.addNumber(1);
        finder.addNumber(2);

        System.out.println(
                finder.findMedian()
        );

        finder.addNumber(3);

        System.out.println(
                finder.findMedian()
        );
    }
}
