public class PathSumBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h)
// LeetCode: 112 - Path Sum
