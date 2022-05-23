public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeafNode(root)) {
            return 1;
        }

        int leftDepth = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int rightDepth = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);

        return 1 + Math.min(leftDepth, rightDepth);
    }

    private static boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
