public class BalancedBinaryTreeValidator {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static boolean isBalanced(TreeNode root) {

        return checkHeight(root) != -1;
    }

    static int checkHeight(TreeNode node) {

        if (node == null)
            return 0;

        int left = checkHeight(node.left);

        if (left == -1)
            return -1;

        int right = checkHeight(node.right);

        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}
