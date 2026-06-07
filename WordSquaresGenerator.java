import java.util.*;

public class WordSquaresGenerator {

    static class TrieNode {

        Map<Character, TrieNode> children =
                new HashMap<>();

        List<String> words =
                new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            node.children.putIfAbsent(
                    c,
                    new TrieNode()
            );

            node = node.children.get(c);

            node.words.add(word);
        }
    }

    List<String> getWordsWithPrefix(
            String prefix) {

        TrieNode node = root;

        for (char c : prefix.toCharArray()) {

            if (!node.children.containsKey(c))
                return new ArrayList<>();

            node = node.children.get(c);
        }

        return node.words;
    }

    public List<List<String>> wordSquares(
            String[] words) {

        for (String word : words) {
            insert(word);
        }

        List<List<String>> result =
                new ArrayList<>();

        int size = words[0].length();

        for (String word : words) {

            List<String> square =
                    new ArrayList<>();

            square.add(word);

            backtrack(
                    size,
                    square,
                    result
            );
        }

        return result;
    }

    void backtrack(int size,
                   List<String> square,
                   List<List<String>> result) {

        if (square.size() == size) {

            result.add(
                    new ArrayList<>(square)
            );

            return;
        }

        int idx = square.size();

        StringBuilder prefix =
                new StringBuilder();

        for (String word : square) {

            prefix.append(
                    word.charAt(idx)
            );
        }

        for (String candidate :
                getWordsWithPrefix(
                        prefix.toString()
                )) {

            square.add(candidate);

            backtrack(
                    size,
                    square,
                    result
            );

            square.remove(
                    square.size() - 1
            );
        }
    }
                  }
