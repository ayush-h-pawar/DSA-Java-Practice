import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(
            String text) {

        Map<Character, Integer> lastSeen =
                new HashMap<>();

        int left = 0;
        int maximumLength = 0;

        for (int right = 0;
             right < text.length();
             right++) {

            char currentCharacter =
                    text.charAt(right);

            if (lastSeen.containsKey(currentCharacter)) {

                left = Math.max(
                        left,
                        lastSeen.get(currentCharacter) + 1
                );
            }

            lastSeen.put(
                    currentCharacter,
                    right
            );

            maximumLength =
                    Math.max(
                            maximumLength,
                            right - left + 1
                    );
        }

        return maximumLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeating solver =
                new LongestSubstringWithoutRepeating();

        String text = "abcabcbb";

        System.out.println(
                solver.lengthOfLongestSubstring(
                        text
                )
        );
    }
}
