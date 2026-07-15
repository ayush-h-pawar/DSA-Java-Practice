import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedUnionFind {

    static class DisjointSet {

        private final Map<Integer, Integer> parent =
                new HashMap<>();

        public int find(int node) {

            parent.putIfAbsent(node, node);

            if (parent.get(node) != node) {

                parent.put(
                        node,
                        find(parent.get(node))
                );
            }

            return parent.get(node);
        }

        public void union(int first, int second) {

            int rootFirst = find(first);
            int rootSecond = find(second);

            if (rootFirst != rootSecond) {
                parent.put(rootFirst, rootSecond);
            }
        }
    }

    public int removeStones(int[][] stones) {

        DisjointSet dsu =
                new DisjointSet();

        for (int[] stone : stones) {

            int row = stone[0];

            int column =
                    ~stone[1];

            dsu.union(row, column);
        }

        int components = 0;

        Map<Integer, Boolean> seen =
                new HashMap<>();

        for (int[] stone : stones) {

            int root =
                    dsu.find(stone[0]);

            if (!seen.containsKey(root)) {

                seen.put(root, true);
                components++;
            }
        }

        return stones.length - components;
    }

    public static void main(String[] args) {

        MostStonesRemovedUnionFind solver =
                new MostStonesRemovedUnionFind();

        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        System.out.println(
                solver.removeStones(stones)
        );
    }
}
