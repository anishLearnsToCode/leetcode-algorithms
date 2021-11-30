public class UnivaluedBinaryTree {
    private int val;

    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        return isUnival(root);
    }

    private boolean isUnival(TreeNode root) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnival(root.left) && isUnival(root.right);
    }
}
