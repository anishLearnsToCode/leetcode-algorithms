// https://leetcode.com/problems/evaluate-boolean-binary-tree
// T: O(N)
// S: O(log(N))

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (isLeafNode(root)) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }

        return evaluateTree(root.left) && evaluateTree(root.right);
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
