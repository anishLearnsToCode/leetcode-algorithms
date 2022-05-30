public class HelloWorld {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode.Node root = new PopulatingNextRightPointersInEachNode.Node(1);
        root.left = new PopulatingNextRightPointersInEachNode.Node(2);
        root.right = new PopulatingNextRightPointersInEachNode.Node(3);
        root.left.left = new PopulatingNextRightPointersInEachNode.Node(4);
        root.left.right = new PopulatingNextRightPointersInEachNode.Node(5);
        root.right.left = new PopulatingNextRightPointersInEachNode.Node(6);
        root.right.right = new PopulatingNextRightPointersInEachNode.Node(7);

        TreePrinter.print(root);

        root = PopulatingNextRightPointersInEachNode.connect(root);

        TreePrinter.print(root);
    }
}
