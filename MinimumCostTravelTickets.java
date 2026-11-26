public class MinimumCostTravelTickets {

    // Travel days are strictly increasing. Costs correspond to 1, 7, and 30 days.
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0) {
            return 0;
        }

        int lastDay = days[days.length - 1];
        int[] minimum = new int[lastDay + 1];
        int travelIndex = 0;

        for (int day = 1; day <= lastDay; day++) {
            if (day != days[travelIndex]) {
                minimum[day] = minimum[day - 1];
                continue;
            }

            int daily = minimum[day - 1] + costs[0];
            int weekly = minimum[Math.max(0, day - 7)] + costs[1];
            int monthly = minimum[Math.max(0, day - 30)] + costs[2];
            minimum[day] = Math.min(daily, Math.min(weekly, monthly));
            travelIndex++;
        }

        return minimum[lastDay];
    }
}

// Time Complexity: O(d), where d is the last travel day
// Space Complexity: O(d)
