import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {

    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();

        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = values.get(s.charAt(i));

            if (i + 1 < s.length() &&
                    current < values.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// LeetCode: 13 - Roman to Integer
