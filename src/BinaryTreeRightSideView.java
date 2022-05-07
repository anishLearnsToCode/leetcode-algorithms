// https://leetcode.com/problems/binary-tree-right-side-view
// T: O(n)
// S: O(log(n))

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode root, final List<Integer> result, int level) {
        if (root == null) return;
        if (level == result.size()) result.add(root.val);

        rightSideView(root.right, result, level + 1);
        rightSideView(root.left, result, level + 1);
    }
}
