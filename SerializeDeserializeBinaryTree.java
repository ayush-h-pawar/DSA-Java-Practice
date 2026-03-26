import java.util.*;

public class SerializeDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Serialize (Tree → String)
    static String serialize(TreeNode root) {

        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    // Deserialize (String → Tree)
    static TreeNode deserialize(String data) {

        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {

            TreeNode parent = queue.poll();

            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;

            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        String data = serialize(root);
        System.out.println(data);

        TreeNode newRoot = deserialize(data);
        System.out.println(newRoot.val);
    }
          }
