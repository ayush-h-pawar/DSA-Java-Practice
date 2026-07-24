import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringFinder {

    public String minWindow(
            String source,
            String target) {

        if (source.length() < target.length()) {
            return "";
        }

        Map<Character, Integer> targetCount =
                new HashMap<>();

        for (char character : target.toCharArray()) {

            targetCount.put(
                    character,
                    targetCount.getOrDefault(
                            character,
                            0
                    ) + 1
            );
        }

        Map<Character, Integer> windowCount =
                new HashMap<>();

        int required =
                targetCount.size();

        int formed = 0;

        int left = 0;

        int minimumLength =
                Integer.MAX_VALUE;

        int startIndex = 0;

        for (int right = 0;
             right < source.length();
             right++) {

            char current =
                    source.charAt(right);

            windowCount.put(
                    current,
                    windowCount.getOrDefault(
                            current,
                            0
                    ) + 1
            );

            if (targetCount.containsKey(current)
                    && windowCount.get(current)
                    .intValue()
                    == targetCount.get(current)
                    .intValue()) {

                formed++;
            }

            while (left <= right
                    && formed == required) {

                if (right - left + 1
                        < minimumLength) {

                    minimumLength =
                            right - left + 1;

                    startIndex = left;
                }

                char leftCharacter =
                        source.charAt(left);

                windowCount.put(
                        leftCharacter,
                        windowCount.get(leftCharacter) - 1
                );

                if (targetCount.containsKey(leftCharacter)
                        && windowCount.get(leftCharacter)
                        < targetCount.get(leftCharacter)) {

                    formed--;
                }

                left++;
            }
        }

        return minimumLength
                == Integer.MAX_VALUE
                ? ""
                : source.substring(
                        startIndex,
                        startIndex + minimumLength
                );
    }

    public static void main(String[] args) {

        MinimumWindowSubstringFinder solver =
                new MinimumWindowSubstringFinder();

        System.out.println(
                solver.minWindow(
                        "ADOBECODEBANC",
                        "ABC"
                )
        );
    }
}
