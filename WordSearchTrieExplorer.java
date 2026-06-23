import java.util.*;

public class WordSearchTrieExplorer {

    static class TrieNode {

        TrieNode[] children =
                new TrieNode[26];

        String word;
    }

    public List<String> findWords(
            char[][] board,
            String[] words) {

        TrieNode root = buildTrie(words);

        List<String> result =
                new ArrayList<>();

        for (int row = 0;
             row < board.length;
             row++) {

            for (int col = 0;
                 col < board[0].length;
                 col++) {

                dfs(
                        board,
                        row,
                        col,
                        root,
                        result
                );
            }
        }

        return result;
    }

    private void dfs(
            char[][] board,
            int row,
            int col,
            TrieNode node,
            List<String> result) {

        if (row < 0
                || row >= board.length
                || col < 0
                || col >= board[0].length) {

            return;
        }

        char current = board[row][col];

        if (current == '#'
                || node.children[current - 'a']
                == null) {

            return;
        }

        node = node.children[current - 'a'];

        if (node.word != null) {

            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node, result);
        dfs(board, row - 1, col, node, result);
        dfs(board, row, col + 1, node, result);
        dfs(board, row, col - 1, node, result);

        board[row][col] = current;
    }

    private TrieNode buildTrie(
            String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] =
                            new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        return root;
    }

    public static void main(String[] args) {

        WordSearchTrieExplorer solver =
                new WordSearchTrieExplorer();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {
                "oath",
                "pea",
                "eat",
                "rain"
        };

        System.out.println(
                solver.findWords(board, words)
        );
    }
}
