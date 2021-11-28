import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSequence1 = getLeafSequence(root1);
        List<Integer> leafSequence2 = getLeafSequence(root2);
        return leafSequence1.equals(leafSequence2);
    }

    private List<Integer> getLeafSequence(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getLeafSequence(root, result);
        return result;
    }

    private void getLeafSequence(TreeNode root, List<Integer> leafNodes) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
            return;
        }
        getLeafSequence(root.left, leafNodes);
        getLeafSequence(root.right, leafNodes);
    }
}
