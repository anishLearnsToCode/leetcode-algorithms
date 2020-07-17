// https://leetcode.com/problems/merge-two-sorted-lists/

public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode previous = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                previous.next = l1;
                l1 = l1.next;
            } else {
                previous.next = l2;
                l2 = l2.next;
            }
            previous = previous.next;
        }

        previous.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
