public class StringCompressionInPlace {

    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                String countString = String.valueOf(count);

                for (char digit : countString.toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 443 - String Compression
