public class LongestRepeatingCharacterReplacement {

    static int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            int idx = s.charAt(right) - 'A';
            count[idx]++;

            maxCount = Math.max(maxCount, count[idx]);

            while ((right - left + 1) - maxCount > k) {

                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("AABABBA", 1)); // 4
    }
}
