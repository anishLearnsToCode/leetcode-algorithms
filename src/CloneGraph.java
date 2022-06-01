// https://leetcode.com/problems/clone-graph
// T: O(n)
// S: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    private static final class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        final Map<Integer, Node> graph = new HashMap<>();
        cloneGraph(node, new HashSet<>(), graph);
        return graph.get(node.val);
    }

    private void cloneGraph(Node node, Set<Integer> visited, Map<Integer, Node> newGraph) {
        if (node == null) return;
        if (visited.contains(node.val)) return;
        visited.add(node.val);

        Node current = getNode(newGraph, node.val);
        for (Node adjacent : node.neighbors) {
            Node newNeighbour = getNode(newGraph, adjacent.val);
            current.neighbors.add(newNeighbour);
            cloneGraph(adjacent, visited, newGraph);
        }
    }

    private Node getNode(Map<Integer, Node> graph, int value) {
        if (graph.containsKey(value)) return graph.get(value);
        Node node = new Node(value);
        graph.put(value, node);
        return node;
    }
}
