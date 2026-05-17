import java.util.*;

public class BoundaryTraversalBinaryTree {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static List<Integer> boundaryTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        result.add(root.val);

        addLeftBoundary(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRightBoundary(root.right, result);

        return result;
    }

    static void addLeftBoundary(TreeNode node,
                                List<Integer> result) {

        while (node != null) {

            if (!(node.left == null &&
                  node.right == null)) {

                result.add(node.val);
            }

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    static void addRightBoundary(TreeNode node,
                                 List<Integer> result) {

        Stack<Integer> stack = new Stack<>();

        while (node != null) {

            if (!(node.left == null &&
                  node.right == null)) {

                stack.push(node.val);
            }

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    static void addLeaves(TreeNode node,
                          List<Integer> result) {

        if (node == null)
            return;

        if (node.left == null &&
            node.right == null) {

            result.add(node.val);
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
        }
