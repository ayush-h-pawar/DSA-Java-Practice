public class PermutationInStringChecker {

    public boolean checkInclusion(
            String pattern,
            String text) {

        if (pattern.length() > text.length()) {
            return false;
        }

        int[] patternFrequency =
                new int[26];

        int[] windowFrequency =
                new int[26];

        for (int index = 0;
             index < pattern.length();
             index++) {

            patternFrequency[
                    pattern.charAt(index) - 'a'
            ]++;

            windowFrequency[
                    text.charAt(index) - 'a'
            ]++;
        }

        if (matches(
                patternFrequency,
                windowFrequency)) {

            return true;
        }

        for (int right = pattern.length();
             right < text.length();
             right++) {

            windowFrequency[
                    text.charAt(right) - 'a'
            ]++;

            windowFrequency[
                    text.charAt(
                            right - pattern.length()
                    ) - 'a'
            ]--;

            if (matches(
                    patternFrequency,
                    windowFrequency)) {

                return true;
            }
        }

        return false;
    }

    private boolean matches(
            int[] first,
            int[] second) {

        for (int index = 0;
             index < 26;
             index++) {

            if (first[index] != second[index]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        PermutationInStringChecker solver =
                new PermutationInStringChecker();

        System.out.println(
                solver.checkInclusion(
                        "ab",
                        "eidbaooo"
                )
        );
    }
}
