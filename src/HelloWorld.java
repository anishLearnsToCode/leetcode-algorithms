public class HelloWorld {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int depth = depthTree(root) - 1;
        if (depth == 0) {
            return 1;
        }

        int left = 0, right = (int) Math.pow(2, depth) - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (exists(root, depth, middle)) left = middle + 1;
            else right = middle - 1;
        }

        return (int) Math.pow(2, depth) - 1 + left;
    }

    private static boolean exists(TreeNode root, int depth, int index) {
        TreeNode current = root;
        int value = -1;
        for (int i = 0 ; i < depth ; i++) {
            final int middle = (int) Math.pow(2, depth - 1 - i);
            if (index > value + middle) {
                current = current.right;
                value += middle;
            } else {
                current = current.left;
            }
        }
        return current != null;
    }

    private static int depthTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depthTree(root.left), depthTree(root.right));
    }
}
