public class SameTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        boolean left = (p.left == null && q.left == null) || (p.left != null && q.left != null);
        if (p.left != null && q.left != null) {
            left = isSameTree(p.left, q.left);
        }

        boolean right = (p.right == null && q.right == null) || (p.right != null && q.right != null);
        if (p.right != null && q.right != null) {
            right = isSameTree(p.right, q.right);
        }

        return left && right;
    }
}
