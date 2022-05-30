import java.util.ArrayList;
import java.util.List;

public class NArayTreePreOrderTraversal {
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

    public List<Integer> preorder(Node root) {
        preorderTraversal(root);
        return result;
    }

    private void preorderTraversal(Node root) {
        if (root == null) return;
        result.add(root.val);
        for (Node child :root.children) {
            preorderTraversal(child);
        }
    }
}
