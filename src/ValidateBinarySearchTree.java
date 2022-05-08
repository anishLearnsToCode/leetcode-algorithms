// https://leetcode.com/problems/validate-binary-search-tree
// T: O(n)
// S: O(log(n))

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minLeftVal, long maxRightVal) {
        if (root == null) return true;
        return minLeftVal < root.val
                && root.val < maxRightVal
                && isValidBST(root.left, minLeftVal, root.val)
                && isValidBST(root.right, root.val, maxRightVal);
    }
}
