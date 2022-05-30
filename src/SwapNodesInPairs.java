// https://leetcode.com/problems/swap-nodes-in-pairs
// T: O(n)
// S: O(1)

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, a = head, b = head.next.next, temp;
        head.next.next = head;
        while (a != null) {
            a.next = (b == null || b.next == null ? b : b.next);
            temp = (b == null || b.next == null ? null : b.next.next);
            if (b != null && b.next != null) b.next.next = b;
            a = b;
            b = temp;
        }
        return newHead;
    }
}
