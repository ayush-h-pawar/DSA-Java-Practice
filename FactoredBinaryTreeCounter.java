import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FactoredBinaryTreeCounter {

    private static final int MOD = 1_000_000_007;

    // Values are distinct integers greater than one.
    public int numFactoredBinaryTrees(int[] arr) {
        int[] values = arr.clone();
        Arrays.sort(values);
        Map<Integer, Long> treesByRoot = new HashMap<>();
        long total = 0;

        for (int rootIndex = 0; rootIndex < values.length; rootIndex++) {
            int root = values[rootIndex];
            long trees = 1;
            for (int leftIndex = 0; leftIndex < rootIndex; leftIndex++) {
                int left = values[leftIndex];
                if (root % left == 0) {
                    long rightTrees = treesByRoot.getOrDefault(root / left, 0L);
                    trees = (trees + treesByRoot.get(left) * rightTrees) % MOD;
                }
            }

            treesByRoot.put(root, trees);
            total = (total + trees) % MOD;
        }
        return (int) total;
    }
}

// Time Complexity: O(n^2) expected
// Space Complexity: O(n)
