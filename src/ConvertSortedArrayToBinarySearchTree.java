public class ConvertSortedArrayToBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] array) {
        return sortedArrayToBST(array, 0, array.length);
    }

    public static TreeNode sortedArrayToBST(int[] array, int start, int end) {
        if (end - start == 0) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = sortedArrayToBST(array, start, mid);
        root.right = sortedArrayToBST(array, mid + 1, end);
        return root;
    }
}
