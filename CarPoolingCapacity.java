import java.util.Map;
import java.util.TreeMap;

public class CarPoolingCapacity {

    // Each trip contains the passenger count, pickup location, and drop-off location.
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Long> changes = new TreeMap<>();
        for (int[] trip : trips) {
            changes.merge(trip[1], (long) trip[0], Long::sum);
            changes.merge(trip[2], -(long) trip[0], Long::sum);
        }

        long onboard = 0;
        // Combining changes at each stop allows drop-offs to free seats for pickups.
        for (long change : changes.values()) {
            onboard += change;
            if (onboard > capacity) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity: O(n log(n + 1))
// Space Complexity: O(n)
