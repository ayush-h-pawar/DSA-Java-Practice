public class BinaryTreeCameras {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int cameras = 0;

    static int dfs(TreeNode root) {

        if (root == null)
            return 2;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        if (left == 1 || right == 1)
            return 2;

        return 0;
    }

    static int minCameraCover(TreeNode root) {

        cameras = 0;

        if (dfs(root) == 0)
            cameras++;

        return cameras;
    }
}
