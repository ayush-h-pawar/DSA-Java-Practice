public class NumberOfConnectedComponents {

    static int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};

        System.out.println(countComponents(n, edges)); // Output: 2
    }
}
