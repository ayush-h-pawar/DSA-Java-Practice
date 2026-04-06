public class FlattenBinaryTreeToLinkedList {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }

        curr.right = right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        flatten(root);

        // Output will be 1 -> 2 -> 3 -> 4 -> 5 ...
    }
                                  }
