public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    private void mergeTrees(TreeNode result, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return;
        if (root1 == null) result.val = root2.val;
        else if (root2 == null) result.val = root1.val;
        else result.val = root1.val + root2.val;
        if ((root1 != null && root1.left != null) || (root2 != null && root2.left != null)) {
            result.left = new TreeNode();
            mergeTrees(result.left, root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        }
        if ((root1 != null && root1.right != null) || (root2 != null && root2.right != null)) {
            result.right = new TreeNode();
            mergeTrees(result.right, root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        }
    }
}
