// T: O(n)
// S: O(1)

public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode start = new ListNode();
        start.next = head;

        ListNode temp = start;
        int i = 1;
        for ( ; i < left ; i++) {
            temp = temp.next;
        }

        ListNode a = temp.next, b = temp.next.next, c = temp.next.next.next;
        a.next = null;

        for ( ; i < right && c != null; i++) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        if (i < right) {
            b.next = a;
            if (left != 1) {
                temp.next = b;
                return start.next;
            }
            return b;
        }
        temp.next.next = b;
        temp.next = a;
        return start.next;
    }
}
