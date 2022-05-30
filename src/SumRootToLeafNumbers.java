// https://leetcode.com/problems/sum-root-to-leaf-numbers
// T: O(n)
// S: O(log(n))

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currentSum) {
        if (root == null) return 0;
        if (isLeafNode(root)) return 10 * currentSum + root.val;
        return sumNumbers(root.left, 10 * currentSum + root.val)
                + sumNumbers(root.right, 10 * currentSum + root.val);
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
