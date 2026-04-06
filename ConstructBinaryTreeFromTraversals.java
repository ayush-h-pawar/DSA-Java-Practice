import java.util.*;

public class ConstructBinaryTreeFromTraversals {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static Map<Integer, Integer> map;

    static TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, 0);
    }

    static TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart) {

        if (preStart > preEnd)
            return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);
        int leftSize = inIndex - inStart;

        root.left = helper(preorder,
                preStart + 1,
                preStart + leftSize,
                inStart);

        root.right = helper(preorder,
                preStart + leftSize + 1,
                preEnd,
                inIndex + 1);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println(root.val); // 3
    }
          }
