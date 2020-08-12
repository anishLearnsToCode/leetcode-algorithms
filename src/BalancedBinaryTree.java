public class BalancedBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(rightDepth - leftDepth) > 1) {
            return -1;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
