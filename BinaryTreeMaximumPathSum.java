public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    static int maxGain(TreeNode root) {

        if (root == null)
            return 0;

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        int currentPath = root.val + left + right;

        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(left, right);
    }

    static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root)); // Output: 42
    }
}
