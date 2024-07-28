// T: O(N + E alp(N))
// S: O(N)

import java.security.cert.Certificate;
import java.util.LinkedList;
import java.util.Queue;



public class HelloWorld {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node current = null;

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    current = null;
                }
                continue;
            }

            addChildrenToQueue(queue, node);

            if (current != null) {
                current.next = node;
            }
            current = node;
        }

        return root;
    }

    private static void addChildrenToQueue(Queue<Node> queue, Node node) {
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}