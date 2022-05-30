public class TreeNode implements TreePrinter.PrintableNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}

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
