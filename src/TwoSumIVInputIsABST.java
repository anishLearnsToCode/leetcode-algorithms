import java.util.HashSet;
import java.util.Set;


public class TwoSumIVInputIsABST {
    Set<Integer> elements = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root ==  null) return false;
        if (elements.contains(k - root.val)) return true;
        elements.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
