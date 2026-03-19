public class CapacityToShipPackages {

    static int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static boolean canShip(int[] weights, int days, int capacity) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {

            if (currentWeight + w > capacity) {
                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += w;
        }

        return requiredDays <= days;
    }

    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days)); // Output: 15
    }
}
