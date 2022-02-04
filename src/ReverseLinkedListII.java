public class ReverseLinkedListII {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }

        @Override
        public String toString() {
            if (next == null) return "ListNode{val=" + val + ", next=null}";
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
