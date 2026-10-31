public class KokoBananaEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return hours <= h;
    }
}

// Time Complexity: O(n log M), where M is the maximum pile size
// Space Complexity: O(1)
// LeetCode: 875 - Koko Eating Bananas
