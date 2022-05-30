import java.util.List;

public class MaximumDepthOfNAryTree {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return 1 + maxDepth;
    }
}
