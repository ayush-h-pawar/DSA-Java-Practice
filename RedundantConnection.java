public class RedundantConnection {

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x), py = find(y);

            if (px == py) return false; // cycle

            parent[px] = py;
            return true;
        }
    }

    static int[] findRedundantConnection(int[][] edges) {

        UnionFind uf = new UnionFind(edges.length);

        for (int[] e : edges) {
            if (!uf.union(e[0], e[1]))
                return e;
        }

        return new int[]{};
    }
}
