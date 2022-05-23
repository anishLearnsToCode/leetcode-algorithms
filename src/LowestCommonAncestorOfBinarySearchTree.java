import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = pathTo(root, p);
        List<TreeNode> pathToQ = pathTo(root, q);
        return lowestCommonAncestor(pathToP, pathToQ);
    }

    private static List<TreeNode> pathTo(TreeNode root, TreeNode to) {
        List<TreeNode> path = new ArrayList<>();
        while (root != to) {
            path.add(root);
            if (to.val < root.val) root = root.left;
            else root = root.right;
        }
        path.add(to);
        return path;
    }

    private static TreeNode lowestCommonAncestor(List<TreeNode> path1, List<TreeNode> path2) {
        for (int index = 1 ; index < Math.min(path1.size(), path2.size()) ; index++) {
            if (!path1.get(index).equals(path2.get(index))) {
                return path1.get(index - 1);
            }
        }
        return path1.get(Math.min(path1.size(), path2.size()) - 1);
    }
}
