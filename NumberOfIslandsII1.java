import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII1 {

    static class DisjointSet {

        private final int[] parent;
        private final int[] rank;

        DisjointSet(int size) {

            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = -1;
            }
        }

        void addLand(int node) {
            parent[node] = node;
        }

        boolean isLand(int node) {
            return parent[node] != -1;
        }

        int find(int node) {

            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        boolean union(int first, int second) {

            int rootFirst = find(first);
            int rootSecond = find(second);

            if (rootFirst == rootSecond) {
                return false;
            }

            if (rank[rootFirst] < rank[rootSecond]) {

                parent[rootFirst] = rootSecond;

            } else if (rank[rootFirst] > rank[rootSecond]) {

                parent[rootSecond] = rootFirst;

            } else {

                parent[rootSecond] = rootFirst;
                rank[rootFirst]++;
            }

            return true;
        }
    }

    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public List<Integer> numIslands2(
            int rows,
            int cols,
            int[][] positions) {

        List<Integer> answer =
                new ArrayList<>();

        DisjointSet dsu =
                new DisjointSet(rows * cols);

        boolean[][] land =
                new boolean[rows][cols];

        int islands = 0;

        for (int[] position : positions) {

            int row = position[0];
            int col = position[1];

            if (land[row][col]) {

                answer.add(islands);
                continue;
            }

            land[row][col] = true;

            int current =
                    row * cols + col;

            dsu.addLand(current);
            islands++;

            for (int[] direction : DIRECTIONS) {

                int newRow =
                        row + direction[0];

                int newCol =
                        col + direction[1];

                if (newRow < 0
                        || newRow >= rows
                        || newCol < 0
                        || newCol >= cols
                        || !land[newRow][newCol]) {

                    continue;
                }

                int neighbor =
                        newRow * cols + newCol;

                if (dsu.union(current, neighbor)) {
                    islands--;
                }
            }

            answer.add(islands);
        }

        return answer;
    }

    public static void main(String[] args) {

        NumberOfIslandsII solver =
                new NumberOfIslandsII();

        int[][] positions = {
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1},
                {1, 1}
        };

        System.out.println(
                solver.numIslands2(
                        3,
                        3,
                        positions
                )
        );
    }
}
