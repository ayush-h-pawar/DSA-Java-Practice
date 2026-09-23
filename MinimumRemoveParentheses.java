import java.util.Stack;

public class MinimumRemoveParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        boolean[] remove = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                if (stack.isEmpty()) {
                    remove[i] = true;
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 1249 - Minimum Remove to Make Valid Parentheses
