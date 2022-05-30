public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int target) {
        ListNode result = new ListNode(-1, head), current = result;
        while (current != null) {
            if (current.next != null && current.next.val == target) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return result.next;
    }
}
