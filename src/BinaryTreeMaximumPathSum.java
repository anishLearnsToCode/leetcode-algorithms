// https://leetcode.com/problems/binary-tree-maximum-path-sum
// T: O(N)
// S: O(logN)

public class BinaryTreeMaximumPathSum {
    private static int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
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

        final int maxSumLeftSubtree = Math.max(maxSum(root.left), 0);
        final int maxSumRightSubtree = Math.max(maxSum(root.right), 0);
        final int maxPathSum = root.val + maxSumLeftSubtree + maxSumRightSubtree;
        result = Math.max(result, maxPathSum);

        return Math.max(root.val + maxSumLeftSubtree, root.val + maxSumRightSubtree);
    }
}
