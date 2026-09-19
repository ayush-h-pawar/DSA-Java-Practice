import java.util.*;

public class BinaryTreePathsFinder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    private void findPaths(
            TreeNode node,
            String path,
            List<String> result) {

        if (node == null) {
            return;
        }

        if (path.isEmpty()) {
            path = String.valueOf(node.val);
        } else {
            path += "->" + node.val;
        }

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        findPaths(node.left, path, result);
        findPaths(node.right, path, result);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h) excluding output
// LeetCode: 257 - Binary Tree Paths
