import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostKDistinct {

    public int lengthOfLongestSubstringKDistinct(
            String text,
            int k) {

        if (text == null
                || text.length() == 0
                || k == 0) {

            return 0;
        }

        Map<Character, Integer> frequency =
                new HashMap<>();

        int left = 0;
        int maximumLength = 0;

        for (int right = 0;
             right < text.length();
             right++) {

            char currentCharacter =
                    text.charAt(right);

            frequency.put(
                    currentCharacter,
                    frequency.getOrDefault(
                            currentCharacter,
                            0
                    ) + 1
            );

            while (frequency.size() > k) {

                char leftCharacter =
                        text.charAt(left);

                frequency.put(
                        leftCharacter,
                        frequency.get(leftCharacter) - 1
                );

                if (frequency.get(leftCharacter) == 0) {
                    frequency.remove(leftCharacter);
                }

                left++;
            }

            maximumLength =
                    Math.max(
                            maximumLength,
                            right - left + 1
                    );
        }

        return maximumLength;
    }

    public static void main(String[] args) {

        LongestSubstringAtMostKDistinct solver =
                new LongestSubstringAtMostKDistinct();

        String text = "eceba";

        System.out.println(
                solver.lengthOfLongestSubstringKDistinct(
                        text,
                        2
                )
        );
    }
}
