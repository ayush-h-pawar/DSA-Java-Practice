public class GoatLatinTranslator {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char first = Character.toLowerCase(word.charAt(0));

            if (first == 'a' || first == 'e' || first == 'i'
                    || first == 'o' || first == 'u') {
                result.append(word);
            } else {
                result.append(word.substring(1));
                result.append(word.charAt(0));
            }

            result.append("ma");

            // Add one 'a' for each word's position
            for (int j = 0; j <= i; j++) {
                result.append('a');
            }

            if (i < words.length - 1) {
                result.append(' ');
            }
        }

        return result.toString();
    }
}

// Time Complexity: O(n + w²), where w is the number of words
// Space Complexity: O(n + w²) for the output
// LeetCode: 824 - Goat Latin
