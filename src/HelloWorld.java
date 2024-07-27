import java.util.*;

public class HelloWorld {
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static Node cloneGraph(Node root) {
        final Queue<Node> queue = new LinkedList<>();
        final Map<Node, Node> oldToNew = new HashMap<>();
        final Set<Node> processed = new HashSet<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (processed.contains(node)) {
                continue;
            }
            processed.add(node);

            final Node newNode = oldToNew.getOrDefault(node, new Node(node.val));
            oldToNew.putIfAbsent(node, newNode);

            for (Node edge : node.neighbors) {
                final Node newEdge = oldToNew.getOrDefault(edge, new Node(edge.val));
                oldToNew.putIfAbsent(edge, newEdge);
                newNode.neighbors.add(newEdge);
                queue.add(edge);
            }
        }

        return oldToNew.get(root);
    }

    public static void main(String[] args) {
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);
        final Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        final Node clone = cloneGraph(node1);
        System.out.println(clone);
    }
}