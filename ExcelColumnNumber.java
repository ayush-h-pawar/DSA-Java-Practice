public class ExcelColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            int value = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + value;
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 171 - Excel Sheet Column Number
