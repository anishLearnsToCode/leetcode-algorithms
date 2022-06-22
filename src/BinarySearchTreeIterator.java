// https://leetcode.com/problems/binary-search-tree-iterator
// T: O(N)
// T(next): O(1)
// T(hasNext): O(1)
// S: O(log(N))

import java.util.Stack;

public class BinarySearchTreeIterator {

    public static final class BSTIterator {
        private final Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            addLeftNodesPathToStack(root);
        }

        public int next() {
            final TreeNode node = stack.pop();
            addLeftNodesPathToStack(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void addLeftNodesPathToStack(TreeNode root) {
            if (root == null) return;
            stack.push(root);
            addLeftNodesPathToStack(root.left);
        }
    }
}
