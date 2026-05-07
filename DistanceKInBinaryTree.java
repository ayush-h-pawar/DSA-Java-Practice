import java.util.*;

public class DistanceKInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    static List<Integer> distanceK(TreeNode root,
                                   TreeNode target,
                                   int k) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParent(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) {

                List<Integer> result = new ArrayList<>();

                for (TreeNode node : queue)
                    result.add(node.val);

                return result;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null &&
                    visited.add(node.left)) {

                    queue.offer(node.left);
                }

                if (node.right != null &&
                    visited.add(node.right)) {

                    queue.offer(node.right);
                }

                TreeNode parent = parentMap.get(node);

                if (parent != null &&
                    visited.add(parent)) {

                    queue.offer(parent);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    static void buildParent(TreeNode node,
                            TreeNode parent,
                            Map<TreeNode, TreeNode> map) {

        if (node == null) return;

        map.put(node, parent);

        buildParent(node.left, node, map);
        buildParent(node.right, node, map);
    }
}
