public class TrieImplementation {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    static class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                int i = c - 'a';

                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }

                node = node.children[i];
            }

            node.isEnd = true;
        }

        boolean search(String word) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                int i = c - 'a';

                if (node.children[i] == null)
                    return false;

                node = node.children[i];
            }

            return node.isEnd;
        }

        boolean startsWith(String prefix) {

            TrieNode node = root;

            for (char c : prefix.toCharArray()) {

                int i = c - 'a';

                if (node.children[i] == null)
                    return false;

                node = node.children[i];
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.startsWith("app")); // true
    }
        }
