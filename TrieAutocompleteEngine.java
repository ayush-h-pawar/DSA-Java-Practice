import java.util.ArrayList;
import java.util.List;

public class TrieAutocompleteEngine {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        boolean isWord;
    }

    private final TrieNode root;

    public TrieAutocompleteEngine() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (char character :
                word.toCharArray()) {

            int index =
                    character - 'a';

            if (current.children[index] == null) {

                current.children[index] =
                        new TrieNode();
            }

            current =
                    current.children[index];
        }

        current.isWord = true;
    }

    public List<String> autocomplete(
            String prefix) {

        List<String> results =
                new ArrayList<>();

        TrieNode node =
                findPrefix(prefix);

        if (node == null) {
            return results;
        }

        collectWords(
                node,
                new StringBuilder(prefix),
                results
        );

        return results;
    }

    private TrieNode findPrefix(
            String prefix) {

        TrieNode current = root;

        for (char character :
                prefix.toCharArray()) {

            int index =
                    character - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current =
                    current.children[index];
        }

        return current;
    }

    private void collectWords(
            TrieNode node,
            StringBuilder currentWord,
            List<String> results) {

        if (node.isWord) {
            results.add(
                    currentWord.toString()
            );
        }

        for (int index = 0;
             index < 26;
             index++) {

            if (node.children[index] != null) {

                currentWord.append(
                        (char) ('a' + index)
                );

                collectWords(
                        node.children[index],
                        currentWord,
                        results
                );

                currentWord.deleteCharAt(
                        currentWord.length() - 1
                );
            }
        }
    }

    public static void main(String[] args) {

        TrieAutocompleteEngine engine =
                new TrieAutocompleteEngine();

        engine.addWord("apple");
        engine.addWord("app");
        engine.addWord("application");
        engine.addWord("apply");
        engine.addWord("banana");

        System.out.println(
                engine.autocomplete("app")
        );
    }
}
