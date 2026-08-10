public class ImplementTriePrefixTree {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        boolean isWord;
    }

    private final TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        for (char character : word.toCharArray()) {

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

    public boolean search(String word) {

        TrieNode node =
                findNode(word);

        return node != null
                && node.isWord;
    }

    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    private TrieNode findNode(
            String text) {

        TrieNode current = root;

        for (char character :
                text.toCharArray()) {

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

    public static void main(String[] args) {

        ImplementTriePrefixTree trie =
                new ImplementTriePrefixTree();

        trie.insert("apple");

        System.out.println(
                trie.search("apple")
        );

        System.out.println(
                trie.search("app")
        );

        System.out.println(
                trie.startsWith("app")
        );

        trie.insert("app");

        System.out.println(
                trie.search("app")
        );
    }
}
