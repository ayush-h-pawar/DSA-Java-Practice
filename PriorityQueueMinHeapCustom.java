import java.util.*;

public class PriorityQueueMinHeapCustom {

    static class MinHeap {

        List<Integer> heap;

        MinHeap() {

            heap = new ArrayList<>();
        }

        void insert(int val) {

            heap.add(val);

            int idx =
                    heap.size() - 1;

            while (idx > 0) {

                int parent =
                        (idx - 1) / 2;

                if (heap.get(parent)
                    <= heap.get(idx)) {

                    break;
                }

                swap(parent, idx);

                idx = parent;
            }
        }

        int removeMin() {

            if (heap.isEmpty())
                return -1;

            int min = heap.get(0);

            int last =
                    heap.remove(
                            heap.size() - 1
                    );

            if (!heap.isEmpty()) {

                heap.set(0, last);

                heapify(0);
            }

            return min;
        }

        void heapify(int idx) {

            int smallest = idx;

            int left =
                    2 * idx + 1;

            int right =
                    2 * idx + 2;

            if (left < heap.size() &&
                heap.get(left)
                < heap.get(smallest)) {

                smallest = left;
            }

            if (right < heap.size() &&
                heap.get(right)
                < heap.get(smallest)) {

                smallest = right;
            }

            if (smallest != idx) {

                swap(idx, smallest);

                heapify(smallest);
            }
        }

        void swap(int i, int j) {

            int temp = heap.get(i);

            heap.set(i,
                    heap.get(j));

            heap.set(j, temp);
        }
    }

    public static void main(String[] args) {

        MinHeap heap =
                new MinHeap();

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        System.out.println(
                heap.removeMin()
        );
    }
}
