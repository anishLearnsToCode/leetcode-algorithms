public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (low <= root.val && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        if (root.val < low) return rangeSumBST(root.right, low, high);
        return rangeSumBST(root.left, low, high);
    }
}
