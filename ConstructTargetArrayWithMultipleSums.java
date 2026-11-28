import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    // All target values are positive, and the initial array consists of ones.
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maximums = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int value : target) {
            maximums.add(value);
            sum += value;
        }

        while (maximums.element() > 1) {
            int largest = maximums.remove();
            long rest = sum - largest;
            if (rest == 1) {
                return true;
            }
            if (rest == 0 || rest >= largest) {
                return false;
            }

            // Undo consecutive updates to the same index in one step.
            int previous = (int) (largest % rest);
            if (previous == 0) {
                return false;
            }
            sum = rest + previous;
            maximums.add(previous);
        }
        return true;
    }
}

// Time Complexity: O((n + log(sum)) * log(n + 1))
// Space Complexity: O(n)
