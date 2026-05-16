import java.util.*;

public class ZigzagBinaryTreeTraversal {

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            LinkedList<Integer> level =
                    new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (leftToRight) {

                    level.addLast(node.val);

                } else {

                    level.addFirst(node.val);
                }

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(level);

            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(
                zigzagLevelOrder(root)
        );
    }
}
