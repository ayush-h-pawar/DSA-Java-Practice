import java.util.*;

public class LongestSubstringWithAtMostKDistinct {

    static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0)
                    map.remove(leftChar);

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
    }
}
