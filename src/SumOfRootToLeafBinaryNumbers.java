public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum + root.val;
        return sumRootToLeaf(root.left, (sum + root.val) << 1) + sumRootToLeaf(root.right, (sum + root.val) << 1);
    }
}
