public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int up = 1;
        int down = 1;
        int result = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 1;
            } else {
                up = 1;
                down = 1;
            }

            result = Math.max(result, Math.max(up, down));
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
