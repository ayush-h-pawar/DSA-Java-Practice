import java.util.*;

public class BinaryTreeVerticalOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int column;

        Pair(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> columns = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        int minColumn = 0;
        int maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            TreeNode node = current.node;
            int column = current.column;

            columns
                .computeIfAbsent(column, key -> new ArrayList<>())
                .add(node.val);

            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (node.left != null) {
                queue.offer(new Pair(node.left, column - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, column + 1));
            }
        }

        for (int column = minColumn; column <= maxColumn; column++) {
            result.add(columns.get(column));
        }

        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 314 - Binary Tree Vertical Order Traversal
