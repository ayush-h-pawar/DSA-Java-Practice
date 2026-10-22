import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumRestaurants {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String restaurant = list2[j];

            if (indexMap.containsKey(restaurant)) {
                int indexSum = indexMap.get(restaurant) + j;

                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    result.clear();
                    result.add(restaurant);
                } else if (indexSum == minIndexSum) {
                    result.add(restaurant);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}

// Time Complexity: O(m + n)
// Space Complexity: O(m + r), where r is the result size
// LeetCode: 599 - Minimum Index Sum of Two Lists
