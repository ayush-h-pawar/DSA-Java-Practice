public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1;
        int j = 0;

        for (int value : pushed) {
            stack[++top] = value;

            while (top >= 0 && j < popped.length
                    && stack[top] == popped[j]) {
                top--;
                j++;
            }
        }

        return j == popped.length;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
