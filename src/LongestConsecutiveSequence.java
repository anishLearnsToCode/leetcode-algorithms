// https://leetcode.com/problems/longest-consecutive-sequence
// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    private static class Node {
        Node next;
        Node previous;
    }

    public int longestConsecutive(int[] nums) {
        final Map<Integer, Node> nodes = createDisjointSets(nums);
        return longestConsecutiveSequenceLength(nodes);
    }

    private Map<Integer, Node> createDisjointSets(int[] array) {
        final Map<Integer, Node> result = new HashMap<>();
        for (int element : array) {
            if (result.containsKey(element)) continue;

            Node current = new Node();

            if (result.containsKey(element - 1)) {
                Node left = result.get(element - 1);
                left.next = current;
                current.previous = left;
            }

            if (result.containsKey(element + 1)) {
                Node right = result.get(element + 1);
                current.next = right;
                right.previous = current;
            }

            result.put(element, current);
        }

        return result;
    }

    private int longestConsecutiveSequenceLength(Map<Integer, Node> nodes) {
        final Set<Node> processedNodes = new HashSet<>();
        int maxLength = 0;

        for (Node node : nodes.values()) {
            int length = getLength(node, processedNodes);
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    private int getLength(Node node, Set<Node> processedNodes) {
        if (node == null) return 0;
        if (processedNodes.contains(node)) return 0;
        processedNodes.add(node);
        return 1 + getLength(node.previous, processedNodes) + getLength(node.next, processedNodes);
    }
}
