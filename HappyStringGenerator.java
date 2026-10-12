public class HappyStringGenerator {

    private int count;
    private String result;

    public String getHappyString(int n, int k) {
        count = 0;
        result = "";

        StringBuilder current = new StringBuilder();
        generate(n, k, current);

        return result;
    }

    private void generate(int n, int k, StringBuilder current) {
        if (!result.isEmpty()) {
            return;
        }

        if (current.length() == n) {
            count++;

            if (count == k) {
                result = current.toString();
            }

            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            int length = current.length();

            if (length > 0 && current.charAt(length - 1) == ch) {
                continue;
            }

            current.append(ch);
            generate(n, k, current);
            current.deleteCharAt(current.length() - 1);

            if (!result.isEmpty()) {
                return;
            }
        }
    }
}

// Time Complexity: O(3 * 2^(n - 1)) in the worst case
// Space Complexity: O(n) auxiliary space, excluding the output
// LeetCode: 1415 - The k-th Lexicographical String of All Happy Strings of Length n
