import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
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
