public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        final int length = length(head);
        final int removalIndex = length - n;
        if (removalIndex == 0) return head.next;
        ListNode current = head;
        for (int i = 0 ; i < removalIndex - 1 ; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    private int length(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
