import java.util.*;

public class FindAllAnagramsInString {

    static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] count = new int[26];

        for (char c : p.toCharArray())
            count[c - 'a']++;

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {

            if (count[s.charAt(right) - 'a'] > 0)
                needed--;

            count[s.charAt(right) - 'a']--;
            right++;

            if (needed == 0)
                result.add(left);

            if (right - left == p.length()) {

                if (count[s.charAt(left) - 'a'] >= 0)
                    needed++;

                count[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0,6]
    }
}
