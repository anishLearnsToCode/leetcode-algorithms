public class HelloWorld {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode start = result;
        for (int i = 1 ; i < left ; i++) {
            start = start.next;
        }

        ListNode startNext = start.next, a = startNext, b = start.next.next;
        for (int count = left ; b != null && count < right ; count++) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        start.next = a;
        startNext.next = b;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
    }
}
