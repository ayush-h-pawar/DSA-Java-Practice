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

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb)
                return false; // cycle detected

            parent[pa] = pb;
            return true;
        }
    }

    static int[] findRedundantConnection(int[][] edges) {

        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1]))
                return edge;
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] res = findRedundantConnection(edges);

        System.out.println(res[0] + " " + res[1]); // 2 3
    }
}
