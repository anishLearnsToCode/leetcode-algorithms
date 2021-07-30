public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        return root.val + "(" + tree2str(root.left) + ")"
                + (root.right == null ? "" : "(" + tree2str(root.right) + ")");
    }
}
