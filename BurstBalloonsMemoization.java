public class BurstBalloonsMemoization {

    static int[][] memo;

    static int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr =
                new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {

            arr[i + 1] = nums[i];
        }

        memo =
                new int[n + 2][n + 2];

        return solve(arr,
                     1,
                     n);
    }

    static int solve(int[] arr,
                     int left,
                     int right) {

        if (left > right)
            return 0;

        if (memo[left][right] != 0)
            return memo[left][right];

        int ans = 0;

        for (int i = left;
             i <= right;
             i++) {

            int coins =
                    arr[left - 1] *
                    arr[i] *
                    arr[right + 1]

                    +

                    solve(arr,
                          left,
                          i - 1)

                    +

                    solve(arr,
                          i + 1,
                          right);

            ans =
                    Math.max(ans,
                             coins);
        }

        memo[left][right] =
                ans;

        return ans;
    }

    public static void main(String[] args) {

        int[] nums =
                {3,1,5,8};

        System.out.println(
                maxCoins(nums)
        );
    }
}
