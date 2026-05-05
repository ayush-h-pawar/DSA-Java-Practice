import java.util.*;

public class VerticalOrderTraversalBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static class NodeInfo {
        int row, col, val;
        NodeInfo(int r, int c, int v) {
            row = r; col = c; val = v;
        }
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<NodeInfo> list = new ArrayList<>();
        dfs(root, 0, 0, list);

        // sort by col → row → value
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo n : list) {

            if (n.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = n.col;
            }

            result.get(result.size() - 1).add(n.val);
        }

        return result;
    }

    static void dfs(TreeNode node, int row, int col,
                    List<NodeInfo> list) {

        if (node == null) return;

        list.add(new NodeInfo(row, col, node.val));

        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
        // [[9],[3,15],[20],[7]]
    }
}
