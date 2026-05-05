public class GraphValidTree {

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);

            if (pa == pb) return false; // cycle

            parent[pa] = pb;
            return true;
        }
    }

    static boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);

        for (int[] e : edges) {
            if (!uf.union(e[0], e[1]))
                return false; // cycle detected
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

        System.out.println(validTree(n, edges)); // true
    }
}
