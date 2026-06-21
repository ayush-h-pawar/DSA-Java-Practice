public class BinaryTreeMaximumPathSum {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        calculate(root);
        return maxSum;
    }

    private int calculate(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftGain =
                Math.max(
                        calculate(node.left),
                        0
                );

        int rightGain =
                Math.max(
                        calculate(node.right),
                        0
                );

        int currentPath =
                node.val
                        + leftGain
                        + rightGain;

        maxSum =
                Math.max(
                        maxSum,
                        currentPath
                );

        return node.val
                + Math.max(
                        leftGain,
                        rightGain
                );
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum solver =
                new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(
                solver.maxPathSum(root)
        );
    }
}
