public class RegionsCutBySlashes {

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

    public int regionsBySlashes(String[] grid) {

        int n = grid.length;

        DisjointSet dsu =
                new DisjointSet(4 * n * n);

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                int root =
                        4 * (row * n + col);

                char current =
                        grid[row].charAt(col);

                if (current == ' ') {

                    dsu.union(root, root + 1);
                    dsu.union(root + 1, root + 2);
                    dsu.union(root + 2, root + 3);

                } else if (current == '/') {

                    dsu.union(root, root + 3);
                    dsu.union(root + 1, root + 2);

                } else {

                    dsu.union(root, root + 1);
                    dsu.union(root + 2, root + 3);
                }

                if (row + 1 < n) {

                    int bottom =
                            4 * ((row + 1) * n + col);

                    dsu.union(root + 2, bottom);
                }

                if (col + 1 < n) {

                    int right =
                            4 * (row * n + col + 1);

                    dsu.union(root + 1, right + 3);
                }
            }
        }

        int regions = 0;

        for (int i = 0;
             i < 4 * n * n;
             i++) {

            if (dsu.find(i) == i) {
                regions++;
            }
        }

        return regions;
    }

    public static void main(String[] args) {

        RegionsCutBySlashes solver =
                new RegionsCutBySlashes();

        String[] grid = {
                " /",
                "/ "
        };

        System.out.println(
                solver.regionsBySlashes(grid)
        );
    }
}
