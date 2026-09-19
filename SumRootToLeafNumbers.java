public class SumRootToLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int sumNumbers(TreeNode root) {
        return calculateSum(root, 0);
    }

    private int calculateSum(TreeNode node, int currentNumber) {
        if (node == null) {
            return 0;
        }

        currentNumber = currentNumber * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        return calculateSum(node.left, currentNumber)
                + calculateSum(node.right, currentNumber);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h)
// LeetCode: 129 - Sum Root to Leaf Numbers
