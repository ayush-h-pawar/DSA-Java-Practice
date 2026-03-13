public class HouseRobberDP {

    static int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {

            int current = Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int[] houses = {2, 7, 9, 3, 1};

        System.out.println(rob(houses)); // Output: 12
    }
}
