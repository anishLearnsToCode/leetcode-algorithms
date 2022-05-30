import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
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

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        postorderTraversal(root);
        return result;
    }

    private void postorderTraversal(Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            postorderTraversal(child);
        }
        result.add(root.val);
    }
}
