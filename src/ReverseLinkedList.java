public class ReverseLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head, ahead = head.next, temp = head.next.next;
        head.next = null;

        while (temp != null) {
            ahead.next = current;
            current = ahead;
            ahead = temp;
            temp = temp.next;
        }
        ahead.next = current;
        return ahead;
    }
}
