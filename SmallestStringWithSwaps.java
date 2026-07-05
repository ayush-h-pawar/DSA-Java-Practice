import java.util.*;

public class SmallestStringWithSwaps {

    static class DisjointSet {

        private final int[] parent;
        private final int[] rank;

        DisjointSet(int size) {

            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {

            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        void union(int first, int second) {

            int rootFirst = find(first);
            int rootSecond = find(second);

            if (rootFirst == rootSecond) {
                return;
            }

            if (rank[rootFirst] < rank[rootSecond]) {
                parent[rootFirst] = rootSecond;
            } else if (rank[rootFirst] > rank[rootSecond]) {
                parent[rootSecond] = rootFirst;
            } else {
                parent[rootSecond] = rootFirst;
                rank[rootFirst]++;
            }
        }
    }

    public String smallestStringWithSwaps(
            String s,
            List<List<Integer>> pairs) {

        int n = s.length();

        DisjointSet dsu = new DisjointSet(n);

        for (List<Integer> pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> groups =
                new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = dsu.find(i);

            groups
                    .computeIfAbsent(
                            root,
                            key -> new PriorityQueue<>())
                    .offer(s.charAt(i));
        }

        StringBuilder answer =
                new StringBuilder();

        for (int i = 0; i < n; i++) {

            int root = dsu.find(i);

            answer.append(
                    groups.get(root).poll()
            );
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        SmallestStringWithSwaps solver =
                new SmallestStringWithSwaps();

        List<List<Integer>> pairs =
                Arrays.asList(
                        Arrays.asList(0, 3),
                        Arrays.asList(1, 2),
                        Arrays.asList(0, 2)
                );

        System.out.println(
                solver.smallestStringWithSwaps(
                        "dcab",
                        pairs
                )
        );
    }
}
