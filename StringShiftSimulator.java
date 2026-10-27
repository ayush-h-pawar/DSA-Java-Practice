public class StringShiftSimulator {

    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        if (n == 0) {
            return s;
        }

        int netShift = 0;

        for (int[] operation : shift) {
            if (operation[0] == 0) {
                netShift -= operation[1];
            } else {
                netShift += operation[1];
            }
        }

        netShift = ((netShift % n) + n) % n;

        return s.substring(n - netShift) + s.substring(0, n - netShift);
    }
}

// Time Complexity: O(n + q), where q is the number of shift operations
// Space Complexity: O(n) for the resulting string
// LeetCode: 1427 - Perform String Shifts
