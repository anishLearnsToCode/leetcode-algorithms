public class IncreasingOrderSearchTree {
    TreeNode current;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode result = new TreeNode();
        current = result;
        inOrderTraversal(root);
        return result.right;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        current.right = new TreeNode(root.val);
        current = current.right;
        inOrderTraversal(root.right);
    }
}
