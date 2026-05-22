import java.util.*;

public class AutocompleteSearchSystem {

    static class TrieNode {

        Map<Character, TrieNode> children =
                new HashMap<>();

        Map<String, Integer> countMap =
                new HashMap<>();

        boolean isEnd;
    }

    TrieNode root;

    String currentInput;

    public AutocompleteSearchSystem(
            String[] sentences,
            int[] times) {

        root = new TrieNode();

        currentInput = "";

        for (int i = 0; i < sentences.length; i++) {

            addSentence(
                    sentences[i],
                    times[i]
            );
        }
    }

    void addSentence(String sentence,
                     int count) {

        TrieNode node = root;

        for (char c :
                sentence.toCharArray()) {

            node.children.putIfAbsent(
                    c,
                    new TrieNode()
            );

            node = node.children.get(c);

            node.countMap.put(
                    sentence,
                    node.countMap.getOrDefault(
                            sentence,
                            0
                    ) + count
            );
        }

        node.isEnd = true;
    }

    public List<String> input(char c) {

        if (c == '#') {

            addSentence(currentInput, 1);

            currentInput = "";

            return new ArrayList<>();
        }

        currentInput += c;

        TrieNode node = root;

        for (char ch :
                currentInput.toCharArray()) {

            if (!node.children.containsKey(ch)) {

                return new ArrayList<>();
            }

            node = node.children.get(ch);
        }

        PriorityQueue<String> pq =
                new PriorityQueue<>(
                        (a, b) -> {

            int cmp =
                    node.countMap.get(a) -
                    node.countMap.get(b);

            if (cmp == 0)
                return b.compareTo(a);

            return cmp;
        });

        for (String s :
                node.countMap.keySet()) {

            pq.offer(s);

            if (pq.size() > 3)
                pq.poll();
        }

        List<String> result =
                new ArrayList<>();

        while (!pq.isEmpty()) {

            result.add(0, pq.poll());
        }

        return result;
    }
}
