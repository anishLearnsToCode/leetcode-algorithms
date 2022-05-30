// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
// T: O(n)
// S: O(n)

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        final List<Integer> list = toList(head);
        return listToBST(list);
    }

    private TreeNode listToBST(List<Integer> list) {
        return listToBST(list, 0, list.size());
    }

    private TreeNode listToBST(List<Integer> list, int start, int end) {
        if (start == end) return null;

        final int middle = start + (end - start) / 2;
        final TreeNode root = new TreeNode(list.get(middle));
        root.left = listToBST(list, start, middle);
        root.right = listToBST(list, middle + 1, end);
        return root;
    }

    private List<Integer> toList(ListNode head) {
        final List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }
}
