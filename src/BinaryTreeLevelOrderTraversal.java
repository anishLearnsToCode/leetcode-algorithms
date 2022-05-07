// https://leetcode.com/problems/binary-tree-level-order-traversal
// T: O(n)
// S: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        final List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                result.add(level);
                if (!queue.isEmpty())  {
                    queue.add(null);
                    level = new ArrayList<>();
                }
            } else {
                level.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return result;
    }
}
