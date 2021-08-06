import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SecondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> elements = treeToSet(root);
        if (elements.size() < 2) return -1;
        Queue<Integer> queue = setToMinHeap(elements);
        queue.poll();
        return queue.peek();
    }

    private static Set<Integer> treeToSet(TreeNode root) {
        Set<Integer> result = new HashSet<>();
        addTreeNodesToSet(root, result);
        return result;
    }

    private static void addTreeNodesToSet(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        addTreeNodesToSet(root.left, set);
        addTreeNodesToSet(root.right, set);
    }

    private static Queue<Integer> setToMinHeap(Set<Integer> elements) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int element : elements) {
            queue.add(element);
        }
        return queue;
    }
}
