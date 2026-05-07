import java.util.*;

public class SubarraysWithKDistinct1 {

    static int subarraysWithKDistinct(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static int atMost(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left],
                        map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0)
                    map.remove(nums[left]);

                left++;
            }

            result += right - left + 1;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,2,3};

        System.out.println(
                subarraysWithKDistinct(nums, 2)
        );
    }
}
