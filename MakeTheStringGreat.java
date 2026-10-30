public class MakeTheStringGreat {

    public String makeGood(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int size = stack.length();

            if (size > 0 &&
                Math.abs(stack.charAt(size - 1) - ch) == 32) {
                stack.deleteCharAt(size - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 1544 - Make The String Great
