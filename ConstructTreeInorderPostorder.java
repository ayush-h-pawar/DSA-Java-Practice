import java.util.HashMap;
import java.util.Map;

public class ConstructTreeInorderPostorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private Map<Integer, Integer> inorderIndex;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
                inorder.length == 0) {
            return null;
        }

        inorderIndex = new HashMap<>();
        postorderIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(
            int[] postorder,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int index = inorderIndex.get(rootValue);

        // Build right subtree first
        root.right = build(postorder, index + 1, right);
        root.left = build(postorder, left, index - 1);

        return root;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 106 - Construct Binary Tree from Inorder and Postorder Traversal
