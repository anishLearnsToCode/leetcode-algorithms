// https://leetcode.com/problems/copy-list-with-random-pointer
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    private static final class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static final Map<Node, Node> nodes = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        for (Node current = head ; current != null ; current = current.next) {
            Node node = getNode(current);
            if (current.next != null) {
                node.next = getNode(current.next);
            }
            if (current.random != null) {
                node.random = getNode(current.random);
            }
        }

        return getNode(head);
    }

    private Node getNode(Node node) {
        if (nodes.containsKey(node)) {
            return nodes.get(node);
        }
        Node copyNode = new Node(node.val);
        nodes.put(node, copyNode);
        return copyNode;
    }
}
