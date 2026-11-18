 private int countAtMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int left = 0;
        int oddCount = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }

                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
