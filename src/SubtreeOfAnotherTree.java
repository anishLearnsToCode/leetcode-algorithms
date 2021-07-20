public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val && areSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean areSame(TreeNode root, TreeNode subTree) {
        if (subTree == null && root == null) return true;
        if (root == null || subTree == null) return false;
        return root.val == subTree.val && areSame(root.left, subTree.left) && areSame(root.right, subTree.right);
    }
}
