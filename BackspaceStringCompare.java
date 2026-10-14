public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidIndex(s, i);
            j = getNextValidIndex(t, j);

            if (i < 0 && j < 0) {
                return true;
            }

            if (i < 0 || j < 0) {
                return false;
            }

            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    private int getNextValidIndex(String s, int index) {
        int backspaces = 0;

        while (index >= 0) {
            if (s.charAt(index) == '#') {
                backspaces++;
            } else if (backspaces > 0) {
                backspaces--;
            } else {
                break;
            }

            index--;
        }

        return index;
    }
}

// Time Complexity: O(m + n)
// Space Complexity: O(1)
// LeetCode: 844 - Backspace String Compare
