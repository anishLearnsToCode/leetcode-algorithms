// https://leetcode.com/problems/kth-smallest-element-in-a-bst
// T: O(k + log(N))
// S: O(log(N))

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        final Stack<TreeNode> stack = new Stack<>();
        addLeftPathToStack(root, stack);

        for (int count = 0 ; !stack.isEmpty() ; ) {
            final TreeNode current = stack.pop();
            count++;
            if (count == k) return current.val;
            addLeftPathToStack(current.right, stack);
        }

        return -1;
    }

    private void addLeftPathToStack(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) return;
        stack.push(root);
        addLeftPathToStack(root.left, stack);
    }
}
