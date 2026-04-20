public class FenwickTree {

    int[] tree;
    int n;

    public FenwickTree(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    // Update index by value
    public void update(int i, int delta) {

        i++; // 1-based indexing

        while (i <= n) {
            tree[i] += delta;
            i += i & (-i);
        }
    }

    // Get prefix sum [0..i]
    public int query(int i) {

        i++;
        int sum = 0;

        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }

        return sum;
    }

    // Range sum [l..r]
    public int rangeQuery(int l, int r) {
        return query(r) - query(l - 1);
    }
}
