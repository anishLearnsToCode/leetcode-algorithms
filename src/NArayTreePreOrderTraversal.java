import java.util.ArrayList;
import java.util.List;

public class NArayTreePreOrderTraversal {
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
