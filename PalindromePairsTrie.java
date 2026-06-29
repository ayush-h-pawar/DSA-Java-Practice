import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairsTrie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
        List<Integer> palindromeSuffixes = new ArrayList<>();
    }

    private final TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {

        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            search(words[i], i, result);
        }

        return result;
    }

    private void insert(String word, int index) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            if (isPalindrome(word, 0, i)) {
                node.palindromeSuffixes.add(index);
            }

            int current = word.charAt(i) - 'a';

            if (node.children[current] == null) {
                node.children[current] = new TrieNode();
            }

            node = node.children[current];
        }

        node.wordIndex = index;
        node.palindromeSuffixes.add(index);
    }

    private void search(
            String word,
            int index,
            List<List<Integer>> result) {

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            if (node.wordIndex >= 0
                    && node.wordIndex != index
                    && isPalindrome(word, i, word.length() - 1)) {

                result.add(
                        Arrays.asList(index, node.wordIndex)
                );
            }

            int current = word.charAt(i) - 'a';

            if (node.children[current] == null) {
                return;
            }

            node = node.children[current];
        }

        for (int other : node.palindromeSuffixes) {

            if (other != index) {
                result.add(Arrays.asList(index, other));
            }
        }
    }

    private boolean isPalindrome(
            String word,
            int left,
            int right) {

        while (left < right) {

            if (word.charAt(left)
                    != word.charAt(right)) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromePairsTrie solver =
                new PalindromePairsTrie();

        String[] words = {
                "abcd",
                "dcba",
                "lls",
                "s",
                "sssll"
        };

        System.out.println(
                solver.palindromePairs(words)
        );
    }
}
