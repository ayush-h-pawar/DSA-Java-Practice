public class FlattenBinaryTreeLinkedList {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {
                TreeNode predecessor = current.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                predecessor.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }
}

// Time Complexity: O(n^2) worst case
// Space Complexity: O(1)
// LeetCode: 114 - Flatten Binary Tree to Linked List
