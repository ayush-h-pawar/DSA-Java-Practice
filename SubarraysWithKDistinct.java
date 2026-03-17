import java.util.HashMap;

public class SubarraysWithKDistinct {

    static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static int atMost(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);

                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k)); // Output: 7
    }
}
