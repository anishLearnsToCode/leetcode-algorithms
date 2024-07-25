// https://leetcode.com/problems/reverse-nodes-in-k-group
// T: O(N)
// S: O(1)

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        final ListNode result = new ListNode(0);
        result.next = head;

        for (ListNode i = result ; i != null ; ) {
            ListNode start = i;

            // go forward k steps
            int count = 0;
            for ( ; count < k && i != null ; count++) {
                i = i.next;
            }

            if (count == k && i != null) {
                i = reverse(start, i);
            }
        }

        return result.next;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode a = start.next, b = start.next.next, terminal = end.next;
        a.next = end.next;
        while (b != terminal) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        ListNode newStart = start.next;
        start.next = a;
        return newStart;
    }
}
