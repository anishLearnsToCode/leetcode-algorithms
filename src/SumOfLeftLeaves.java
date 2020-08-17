public class SumOfLeftLeaves {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0)
                + sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right);
    }
}
