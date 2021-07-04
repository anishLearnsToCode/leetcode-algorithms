import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindModeInBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode previous;
    private static int count = 1;
    private static int mode = 0;

    public static int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> modes = new ArrayList<>();
        findMode(root, modes);
        int[] result = new int[modes.size()];
        for(int index = 0 ; index < modes.size() ; index++) {
            result[index] = modes.get(index);
        }
        previous = null;
        count = 1;
        mode = 0;
        return result;
    }

    private static void findMode(TreeNode root, List<Integer> modes) {
        if (root == null) {
            return;
        }
        findMode(root.left, modes);
        if (previous != null) {
            count = root.val == previous.val ? count + 1 : 1;
        }
        if (count > mode) {
            mode = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == mode) {
            modes.add(root.val);
        }
        previous = root;
        findMode(root.right, modes);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(Arrays.toString(findMode(root)));
    }
}
