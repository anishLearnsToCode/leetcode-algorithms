// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
// T: O(n)
// S: O(n)

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public static Node connect(Node root) {
        if (root == null) return null;

        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node previous = null;

        while (!queue.isEmpty()) {
            final Node current = queue.poll();
            if (current == null) {
                previous = null;
                if (!queue.isEmpty()) queue.add(null);
                continue;
            }

            if (previous != null) previous.next = current;
            previous = current;
            addChildrenToQueue(queue, current);
        }

        return root;
    }

    private static void addChildrenToQueue(Queue<Node> queue, Node root) {
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
    }

    private static class Node implements TreePrinter.PrintableNode {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return val + "";
        }
    }
}
