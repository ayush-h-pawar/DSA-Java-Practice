import java.util.*;

public class WordLadderIIPaths {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> dictionary = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dictionary.contains(endWord))
            return result;

        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;
                        String next = new String(chars);

                        if (!dictionary.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!levelVisited.contains(next)) {
                                queue.offer(next);
                                levelVisited.add(next);
                            }

                            parents.computeIfAbsent(
                                    next,
                                    k -> new ArrayList<>())
                                    .add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }

                    chars[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (found) {
            LinkedList<String> path = new LinkedList<>();
            buildPaths(endWord, beginWord, parents, path, result);
        }

        return result;
    }

    private void buildPaths(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            LinkedList<String> path,
            List<List<String>> result) {

        path.addFirst(word);

        if (word.equals(beginWord)) {
            result.add(new ArrayList<>(path));
        } else {

            List<String> prevWords =
                    parents.getOrDefault(word, Collections.emptyList());

            for (String prev : prevWords) {
                buildPaths(prev, beginWord, parents, path, result);
            }
        }

        path.removeFirst();
    }

    public static void main(String[] args) {

        WordLadderIIPaths solver = new WordLadderIIPaths();

        List<String> words = Arrays.asList(
                "hot", "dot", "dog",
                "lot", "log", "cog"
        );

        System.out.println(
                solver.findLadders("hit", "cog", words)
        );
    }
}
