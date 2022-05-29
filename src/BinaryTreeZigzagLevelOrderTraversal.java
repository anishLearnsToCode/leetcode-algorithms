// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
// T: O(n)
// S: O(n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        final List<List<Integer>> result = new ArrayList<>();
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            final TreeNode current = queue.poll();
            if (current == null) {
                result.add(level);
                level = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            level.add(current.val);
            addChildrenInQueue(queue, current);
        }

        zigZagOrder(result);
        return result;
    }

    private void zigZagOrder(List<List<Integer>> levels) {
        for (int i = 1 ; i < levels.size() ; i += 2) {
            Collections.reverse(levels.get(i));
        }
    }

    private void addChildrenInQueue(Queue<TreeNode> queue, TreeNode root) {
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
    }
}
