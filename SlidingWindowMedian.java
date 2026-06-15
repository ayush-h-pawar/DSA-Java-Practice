import java.util.*;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> result = new ArrayList<>();

        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;

        for (int i = 0; i < nums.length; i++) {

            if (low.isEmpty() || nums[i] <= low.lastKey()) {
                add(low, nums[i]);
                lowSize++;
            } else {
                add(high, nums[i]);
                highSize++;
            }

            while (lowSize > highSize + 1) {
                int val = low.lastKey();
                remove(low, val);
                add(high, val);
                lowSize--;
                highSize++;
            }

            while (lowSize < highSize) {
                int val = high.firstKey();
                remove(high, val);
                add(low, val);
                highSize--;
                lowSize++;
            }

            if (i >= k) {
                int removeVal = nums[i - k];

                if (low.containsKey(removeVal)) {
                    remove(low, removeVal);
                    lowSize--;
                } else {
                    remove(high, removeVal);
                    highSize--;
                }

                while (lowSize > highSize + 1) {
                    int val = low.lastKey();
                    remove(low, val);
                    add(high, val);
                    lowSize--;
                    highSize++;
                }

                while (lowSize < highSize) {
                    int val = high.firstKey();
                    remove(high, val);
                    add(low, val);
                    highSize--;
                    lowSize++;
                }
            }

            if (i >= k - 1) {
                if (k % 2 == 1)
                    result.add((double) low.lastKey());
                else
                    result.add(((double) low.lastKey() + high.firstKey()) / 2.0);
            }
        }

        double[] ans = new double[result.size()];
        for (int i = 0; i < result.size(); i++)
            ans[i] = result.get(i);

        return ans;
    }

    private void add(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0)
            map.remove(num);
    }
}
