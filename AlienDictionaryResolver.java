import java.util.*;

public class AlienDictionaryResolver {

    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            if (first.length() > second.length() &&
                first.startsWith(second))
                return "";

            int minLen = Math.min(first.length(), second.length());

            for (int j = 0; j < minLen; j++) {

                char a = first.charAt(j);
                char b = second.charAt(j);

                if (a != b) {
                    if (!graph.get(a).contains(b)) {
                        graph.get(a).add(b);
                        indegree.put(b, indegree.get(b) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0)
                queue.offer(c);
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0)
                    queue.offer(neighbor);
            }
        }

        return result.length() == indegree.size()
                ? result.toString()
                : "";
    }

    public static void main(String[] args) {
        AlienDictionaryResolver solver = new AlienDictionaryResolver();

        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        System.out.println(solver.alienOrder(words));
    }
}
