import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumRobotsWithinBudget {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> maximumCharges = new ArrayDeque<>();
        long runningSum = 0;
        int left = 0;
        int best = 0;

        for (int right = 0; right < chargeTimes.length; right++) {
            runningSum += runningCosts[right];
            while (!maximumCharges.isEmpty()
                    && chargeTimes[maximumCharges.peekLast()] <= chargeTimes[right]) {
                maximumCharges.removeLast();
            }
            maximumCharges.addLast(right);

            while (left <= right
                    && chargeTimes[maximumCharges.peekFirst()] + (right - left + 1L) * runningSum > budget) {
                if (maximumCharges.peekFirst() == left) {
                    maximumCharges.removeFirst();
                }
                runningSum -= runningCosts[left];
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
