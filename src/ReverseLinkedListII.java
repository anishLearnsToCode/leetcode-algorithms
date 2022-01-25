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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseBetween(head, 2, 4));
    }

    public static ListNode reverseBetween(ListNode head, int leftVal, int rightVal) {
        if (leftVal == rightVal) return head;

        ListNode sentinelHead = new ListNode(-1000);
        sentinelHead.next = head;
        ListNode beforeLeft = getNodeBefore(sentinelHead, leftVal);
        System.out.println(beforeLeft.val);
        ListNode left = beforeLeft.next;
        ListNode a = beforeLeft.next, b = a.next, c = b.next;

        while (c != null && b.val != rightVal) {
            a.next = null;
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;
        beforeLeft.next = b;
        left.next = c;
        return sentinelHead.next;
    }

    private static ListNode getNodeBefore(ListNode head, int value) {
        while (head != null && head.next != null && head.next.val != value) {
            head = head.next;
        }
        return head;
    }
}
