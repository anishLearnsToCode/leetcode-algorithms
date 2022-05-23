public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
        return p == q;
    }
}
