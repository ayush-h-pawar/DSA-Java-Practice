public class DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;

    static int height(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root)); // Output: 3
    }
}
