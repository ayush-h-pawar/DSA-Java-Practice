public class JewelsStonesCounter {

    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];

        for (char ch : jewels.toCharArray()) {
            isJewel[ch] = true;
        }

        int count = 0;

        for (char ch : stones.toCharArray()) {
            if (isJewel[ch]) {
                count++;
            }
        }

        return count;
    }
}

// Time Complexity: O(j + s)
// Space Complexity: O(1)
// LeetCode: 771 - Jewels and Stones

2. UniqueMorseCodeCounter.java
import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeCounter {

    private static final String[] MORSE = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();

        for (String word : words) {
            StringBuilder code = new StringBuilder();

            for (char ch : word.toCharArray()) {
                code.append(MORSE[ch - 'a']);
            }

            transformations.add(code.toString());
        }

        return transformations.size();
    }
}
