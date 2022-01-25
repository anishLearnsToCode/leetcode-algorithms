public class ReverseLinkedListII {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseBetween(ListNode head, int leftVal, int rightVal) {
        if (leftVal == rightVal) return head;

        ListNode sentinelHead = new ListNode(-1000);
        sentinelHead.next = head;
        ListNode beforeLeft = getNodeBefore(sentinelHead, leftVal);
        System.out.println(beforeLeft.val);
        ListNode left = beforeLeft.next;
//        ListNode afterRight = getNodeAfter(sentinelHead, rightVal);
        ListNode a = beforeLeft.next, b = a.next, c = b.next;

        while (c != null && b.val != rightVal) {
            a.next = null;
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        a.next = null;
        b.next = a;
        beforeLeft.next = b;
        left.next = c;
        return sentinelHead.next;
    }

    private ListNode getNodeBefore(ListNode head, int value) {
        while (head != null && head.next != null && head.next.val != value) {
            head = head.next;
        }
        return head;
    }

    private ListNode getNodeAfter(ListNode head, int value) {
        while (head != null && head.val != value) {
            head = head.next;
        }
        return head.next;
    }
}
