import java.util.*;

public class SerializeDeserializeBinaryTree1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.append("null,");
                continue;
            }

            result.append(node.val).append(",");

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null")) {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            if (!values[index].equals("null")) {
                current.left = new TreeNode(
                    Integer.parseInt(values[index])
                );
                queue.offer(current.left);
            }

            index++;

            if (index < values.length && !values[index].equals("null")) {
                current.right = new TreeNode(
                    Integer.parseInt(values[index])
                );
                queue.offer(current.right);
            }

            index++;
        }

        return root;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 297 - Serialize and Deserialize Binary Tree
