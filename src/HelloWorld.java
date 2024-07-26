public class HelloWorld {
    private static int result = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return result;
    }

    private static int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int maxGainLeftSubtree = Math.max(maxSum(root.left), 0);
        final int maxGainRightSubtree = Math.max(maxSum(root.right), 0);
        final int maxPathSum = root.val + maxGainLeftSubtree + maxGainRightSubtree;
        result = Math.max(result, maxPathSum);

        return Math.max(root.val + maxGainLeftSubtree, root.val + maxGainRightSubtree);
    }
}
