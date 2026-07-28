public class LongestRepeatingCharacterReplacement1 {

    public int characterReplacement(
            String text,
            int replacements) {

        int[] frequency =
                new int[26];

        int left = 0;
        int maximumFrequency = 0;
        int longestLength = 0;

        for (int right = 0;
             right < text.length();
             right++) {

            int current =
                    text.charAt(right) - 'A';

            frequency[current]++;

            maximumFrequency =
                    Math.max(
                            maximumFrequency,
                            frequency[current]
                    );

            while ((right - left + 1)
                    - maximumFrequency
                    > replacements) {

                frequency[
                        text.charAt(left) - 'A'
                ]--;

                left++;
            }

            longestLength =
                    Math.max(
                            longestLength,
                            right - left + 1
                    );
        }

        return longestLength;
    }

    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement solver =
                new LongestRepeatingCharacterReplacement();

        String text = "AABABBA";

        System.out.println(
                solver.characterReplacement(
                        text,
                        1
                )
        );
    }
}
