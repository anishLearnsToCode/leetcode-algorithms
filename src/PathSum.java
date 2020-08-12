public class PathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasPathSum(root, sum, root.val);
    }

    private static boolean hasPathSum(TreeNode root, int sum, int current) {
        if (root == null) {
            return false;
        }

        if (isLeafNode(root)) {
            return sum == current;
        }

        boolean leftPathSumExists = root.left != null && hasPathSum(root.left, sum, current + root.left.val);
        boolean rightPathSumExists = root.right != null && hasPathSum(root.right, sum, current + root.right.val);

        return leftPathSumExists || rightPathSumExists;
    }

    private static boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
