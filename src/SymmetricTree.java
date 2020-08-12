public class SymmetricTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        boolean left = (p.left == null && q.right == null) || (p.left != null && q.right != null);
        if (p.left != null && q.right != null) {
            left = isSymmetric(p.left, q.right);
        }

        boolean right = (p.right == null && q.left == null) || (p.right != null && q.left != null);
        if (p.right != null && q.left != null) {
            right = isSymmetric(p.right, q.left);
        }

        return left && right;
    }
}
