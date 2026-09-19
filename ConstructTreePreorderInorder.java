import java.util.*;

public class ConstructTreePreorderInorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private Map<Integer, Integer> inorderIndex;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null ||
                preorder.length == 0) {
            return null;
        }

        inorderIndex = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(
            int[] preorder,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int index = inorderIndex.get(rootValue);

        root.left = build(preorder, left, index - 1);
        root.right = build(preorder, index + 1, right);

        return root;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 105 - Construct Binary Tree from Preorder and Inorder Traversal
