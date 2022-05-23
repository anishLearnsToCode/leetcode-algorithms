import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void binaryTreePaths(TreeNode root, List<CharSequence> path, List<String> paths) {
        if (root == null) {
            return;
        }

        path.add(root.val + "");

        if (isLeafNode(root)) {
            paths.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }

        binaryTreePaths(root.left, path, paths);
        binaryTreePaths(root.right, path, paths);
        path.remove(path.size() - 1);
    }

    private static boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
