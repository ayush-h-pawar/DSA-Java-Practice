public class RecoverBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = null;

    static void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {

            if (first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    static void recoverTree(TreeNode root) {

        first = second = prev = null;

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        recoverTree(root);

        // Inorder should now be sorted
    }
}
