public class ConvertBSTToGreaterTree {
    int value = 0;

    public TreeNode convertBST(TreeNode root) {
        computeGreaterTree(root);
        return root;
    }

    private void computeGreaterTree(TreeNode root) {
        if (root == null) return;
        computeGreaterTree(root.right);
        root.val += value;
        computeGreaterTree(root.left);
    }
}
