public class BinaryTreeTilt {
    public int sumTilts = 0;

    public int findTilt(TreeNode root) {
        computeTilt(root);
        return sumTilts;
    }

    private int computeTilt(TreeNode root) {
        if (root == null) return 0;
        int leftSum = computeTilt(root.left);
        int rightSum = computeTilt(root.right);
        sumTilts += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
