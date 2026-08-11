public class WordDictionaryWildcardSearch {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        boolean isWord;
    }

    private final TrieNode root;

    public WordDictionaryWildcardSearch() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (char character : word.toCharArray()) {

            int index = character - 'a';

            if (current.children[index] == null) {
                current.children[index] =
                        new TrieNode();
            }

            current = current.children[index];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    private boolean searchWord(
            String word,
            int index,
            TrieNode node) {

        if (index == word.length()) {
            return node.isWord;
        }

        char character =
                word.charAt(index);

        if (character == '.') {

            for (TrieNode child :
                    node.children) {

                if (child != null
                        && searchWord(
                                word,
                                index + 1,
                                child)) {

                    return true;
                }
            }

            return false;
        }

        int childIndex =
                character - 'a';

        TrieNode child =
                node.children[childIndex];

        return child != null
                && searchWord(
                        word,
                        index + 1,
                        child
                );
    }

    public static void main(String[] args) {

        WordDictionaryWildcardSearch dictionary =
                new WordDictionaryWildcardSearch();

        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println(
                dictionary.search("pad")
        );

        System.out.println(
                dictionary.search("bad")
        );

        System.out.println(
                dictionary.search(".ad")
        );

        System.out.println(
                dictionary.search("b..")
        );
    }
}
