public class StringRotationChecker {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}

// Time Complexity: O(n) auxiliary string construction;
// substring search depends on the Java implementation.
// Space Complexity: O(n)
// LeetCode: 796 - Rotate String
