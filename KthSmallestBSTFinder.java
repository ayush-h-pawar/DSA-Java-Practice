import java.util.*;

public class KthSmallestBSTFinder {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (true) {

            while (root != null) {

                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            k--;

            if (k == 0)
                return root.val;

            root = root.right;
        }
    }
}
