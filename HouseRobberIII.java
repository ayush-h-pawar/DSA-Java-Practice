public class HouseRobberIII {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int[] dfs(TreeNode root) {

        if (root == null)
            return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) +
                     Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }

    static int rob(TreeNode root) {

        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
}
