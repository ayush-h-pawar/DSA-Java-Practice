import java.util.*;

public class ReplaceWordsTrie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    static TrieNode buildTrie(List<String> dict) {

        TrieNode root = new TrieNode();

        for (String word : dict) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                int i = c - 'a';

                if (node.children[i] == null)
                    node.children[i] = new TrieNode();

                node = node.children[i];
            }

            node.isEnd = true;
        }

        return root;
    }

    static String replaceWords(List<String> dict, String sentence) {

        TrieNode root = buildTrie(dict);

        StringBuilder result = new StringBuilder();

        for (String word : sentence.split(" ")) {

            result.append(findRoot(root, word)).append(" ");
        }

        return result.toString().trim();
    }

    static String findRoot(TrieNode root, String word) {

        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {

            int i = c - 'a';

            if (node.children[i] == null)
                return word;

            prefix.append(c);
            node = node.children[i];

            if (node.isEnd)
                return prefix.toString();
        }

        return word;
    }

    public static void main(String[] args) {

        List<String> dict = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(dict, sentence));
    }
}
