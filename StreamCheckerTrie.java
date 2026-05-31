import java.util.*;

public class StreamCheckerTrie {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        boolean isWord;
    }

    TrieNode root;

    StringBuilder stream;

    public StreamCheckerTrie(
            String[] words) {

        root = new TrieNode();

        stream =
                new StringBuilder();

        for (String word : words) {

            TrieNode node = root;

            for (int i =
                 word.length() - 1;
                 i >= 0;
                 i--) {

                int idx =
                        word.charAt(i)
                        - 'a';

                if (node.children[idx]
                    == null) {

                    node.children[idx] =
                            new TrieNode();
                }

                node =
                        node.children[idx];
            }

            node.isWord = true;
        }
    }

    public boolean query(char letter) {

        stream.append(letter);

        TrieNode node = root;

        for (int i =
             stream.length() - 1;
             i >= 0;
             i--) {

            int idx =
                    stream.charAt(i)
                    - 'a';

            if (node.children[idx]
                == null) {

                return false;
            }

            node =
                    node.children[idx];

            if (node.isWord)
                return true;
        }

        return false;
    }
}
