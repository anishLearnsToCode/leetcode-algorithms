// https://leetcode.com/problems/count-complete-tree-nodes
// T: O(log(n) ^ 2)
// S: O(log(n))

public class CountCompleteTreeNodes {
    private static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + depth(root.left);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return 1 + (leftDepth == rightDepth
                ? ((1 << leftDepth) - 1) + countNodes(root.right)
                : countNodes(root.left) + countNodes(root.right));
    }
}
