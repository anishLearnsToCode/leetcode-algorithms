// https://leetcode.com/problems/recover-binary-search-tree
// T: O(n)
// S: O(log(n))

public class RecoverBinarySearchTree {
    TreeNode first, second, previous = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        swapValues(first, second);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (first == null && root.val < previous.val) {
            first = previous;
        }
        if (first != null && root.val < previous.val) {
            second = root;
        }
        previous = root;

        inorder(root.right);
    }

    private void swapValues(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
