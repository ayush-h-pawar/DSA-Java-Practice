import java.util.*;

public class SerializeDeserializeBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Serialize (preorder)
    static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    static void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) return;

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    static TreeNode deserialize(String data) {

        if (data.isEmpty()) return null;

        String[] vals = data.split(",");
        Queue<Integer> queue = new LinkedList<>();

        for (String v : vals)
            queue.offer(Integer.parseInt(v));

        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static TreeNode build(Queue<Integer> q, int min, int max) {

        if (q.isEmpty()) return null;

        int val = q.peek();

        if (val < min || val > max)
            return null;

        q.poll();

        TreeNode root = new TreeNode(val);

        root.left = build(q, min, val);
        root.right = build(q, val, max);

        return root;
    }
            }
