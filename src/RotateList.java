// https://leetcode.com/problems/rotate-list
// T: O(N)
// S: O(1)

public class RotateList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        final int length = getLength(head);
        if (length == 0) return head;
        final int rotations = k % length;
        if (rotations == 0) return head;
        final ListNode last = getLastNode(head);
        final ListNode cutoffNode = getCutoffNode(head, rotations, length);
        final ListNode newHead = cutoffNode.next;
        last.next = head;
        cutoffNode.next = null;
        return newHead;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    private ListNode getLastNode(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private ListNode getCutoffNode(ListNode head, int rotations, int length) {
        ListNode current = head;
        for (int i = 0 ; i < length - rotations - 1 ; i++) {
            current = current.next;
        }
        return current;
    }
}
