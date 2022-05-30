// https://leetcode.com/problems/flatten-binary-tree-to-linked-list
// T: O(n)
// S: O(log(n))

public class FlattenBinaryTreeToLinkedList {
    public static void flatten(TreeNode root) {
        flattenAndGetLastNode(root);
    }

    private static TreeNode flattenAndGetLastNode(TreeNode root) {
        if (root == null) return null;

        TreeNode leftLast = flattenAndGetLastNode(root.left);
        TreeNode rightLast = flattenAndGetLastNode(root.right);

        if (root.left != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightLast != null
                ? rightLast
                : (leftLast == null ? root : leftLast);
    }
}
