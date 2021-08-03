import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsOfBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int count = 0;
        List<Double> result = new ArrayList<>();
        result.add(0.0);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null && queue.isEmpty()) break;
            if (current == null) {
                queue.add(null);
                result.set(result.size() - 1, result.get(result.size() - 1) / count);
                result.add(0.0);
                count = 0;
                continue;
            }
            count++;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            result.set(result.size() - 1, result.get(result.size() - 1) + current.val);
        }
        result.set(result.size() - 1, result.get(result.size() - 1) / count);
        return result;
    }
}
