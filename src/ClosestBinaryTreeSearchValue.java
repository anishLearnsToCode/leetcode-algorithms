// https://leetcode.com/problems/closest-binary-search-tree-value
// T: O(logN)
// S: O(logN)

public class ClosestBinaryTreeSearchValue {
    private static int result = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        result = Integer.MAX_VALUE;
        computeClosestValue(root, target);
        return result;
    }

    private static void computeClosestValue(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        if (root.val == target) {
            result = root.val;
            return;
        }

        if (Math.abs(root.val - target) == Math.abs(result - target) && root.val < result) {
            result = root.val;
        } else if (Math.abs(root.val - target) < Math.abs(result - target)) {
            result = root.val;
        }

        if (root.val < target) {
            computeClosestValue(root.right, target);
        } else {
            computeClosestValue(root.left, target);
        }
    }
}
