import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    private static class Pair {
        TreeNode tree;
        int level;

        Pair(TreeNode tree, int level) {
            this.tree = tree;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        List<Integer> level = new ArrayList<>();
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.pop();
            if (pair.level > currentLevel) {
                levels.add(level);
                level = new ArrayList<>();
                currentLevel = pair.level;
            }
            level.add(pair.tree.val);
            addChildrenToQueue(pair, queue);
        }
        levels.add(level);
        Collections.reverse(levels);
        return levels;
    }

    private static void addChildrenToQueue(Pair pair, Queue<Pair> queue) {
        if (pair.tree.left != null) {
            queue.add(new Pair(pair.tree.left, pair.level + 1));
        }
        if (pair.tree.right != null) {
            queue.add(new Pair(pair.tree.right, pair.level + 1));
        }
    }
}
