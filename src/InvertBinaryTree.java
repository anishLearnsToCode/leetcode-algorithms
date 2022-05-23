public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
