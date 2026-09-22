import java.util.*;

public class GroupAnagramsBySignature {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            groups
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(str);
        }

        return new ArrayList<>(groups.values());
    }
}

// Time Complexity: O(n * k log k)
// Space Complexity: O(n * k)
// LeetCode: 49 - Group Anagrams
