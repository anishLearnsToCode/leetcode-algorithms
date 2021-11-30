public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        NodeInfo X = getNodeInfo(root, x);
        NodeInfo Y = getNodeInfo(root, y);
        return X.depth == Y.depth && X.parent != Y.parent;
    }

    private NodeInfo getNodeInfo(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return new NodeInfo(null, 0);
        if (val(root.left) == val || val(root.right) == val) return new NodeInfo(root, 1);
        NodeInfo left = getNodeInfo(root.left, val);
        NodeInfo right = getNodeInfo(root.right, val);
        if (left != null) {
            left.depth++;
            return left;
        }
        if (right != null) {
            right.depth++;
            return right;
        }
        return null;
    }

    private int val(TreeNode root) {
        if (root == null) return 0;
        return root.val;
    }

    private static class NodeInfo {
        TreeNode parent;
        int depth;

        NodeInfo(final TreeNode parent, final int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }
}
