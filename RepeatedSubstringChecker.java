public class RepeatedSubstringChecker {

    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;

        String middle = doubled.substring(1, doubled.length() - 1);

        return middle.contains(s);
    }
}

// Time Complexity: O(n) auxiliary string construction;
// substring search depends on the Java implementation.
// Space Complexity: O(n)
// LeetCode: 459 - Repeated Substring Pattern
