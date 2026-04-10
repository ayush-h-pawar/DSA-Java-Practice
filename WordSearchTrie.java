import java.util.*;

public class WordSearchTrie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    static TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String w : words) {

            TrieNode node = root;

            for (char c : w.toCharArray()) {

                int i = c - 'a';

                if (node.children[i] == null)
                    node.children[i] = new TrieNode();

                node = node.children[i];
            }

            node.word = w;
        }

        return root;
    }

    static List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    static void dfs(char[][] board, int r, int c,
                    TrieNode node, List<String> result) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;

        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null)
            return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        board[r][c] = ch;
    }
}
