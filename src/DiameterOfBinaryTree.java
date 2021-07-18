public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        computerDiameterOfBinaryTree(root);
        return diameter;
    }

    private int computerDiameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = computerDiameterOfBinaryTree(root.left);
        int rightHeight = computerDiameterOfBinaryTree(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
