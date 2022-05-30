// https://leetcode.com/problems/path-sum-ii
// T: O(n * log(n))
// S: O(n * log(n))

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        pathSum(root, targetSum, result);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, final List<List<Integer>> result) {
        pathSum(root, targetSum, result, 0, new LinkedList<>());
    }

    private void pathSum(TreeNode root, int targetSum, final List<List<Integer>> result, int sum, LinkedList<Integer> path) {
        path.addLast(root.val);
        sum += root.val;

        if (isLeafNode(root)) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            pathSum(root.left, targetSum, result, sum, path);
            path.removeLast();
        }
        if (root.right != null) {
            pathSum(root.right, targetSum, result, sum, path);
            path.removeLast();
        }
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
