public class TreeNode implements TreePrinter.PrintableNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}

    public static final TreeNode EXAMPLE_1;

    static {
        EXAMPLE_1 = new TreeNode(7);
        EXAMPLE_1.left = new TreeNode(3);
        EXAMPLE_1.right = new TreeNode(15);
        EXAMPLE_1.right.left = new TreeNode(9);
        EXAMPLE_1.right.right = new TreeNode(20);
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return this.left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return this.right;
    }

    @Override
    public String getText() {
        return this.val + "";
    }
}
