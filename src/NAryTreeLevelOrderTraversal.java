// https://leetcode.com/problems/n-ary-tree-level-order-traversal
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        final List<List<Integer>> result = new ArrayList<>();
        final Queue<Node> queue = new LinkedList<>();
        List<Integer> current = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            if (node == null) {
                result.add(current);
                current = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }

            current.add(node.val);
            queue.addAll(node.children);
        }

        return result;
    }
}
