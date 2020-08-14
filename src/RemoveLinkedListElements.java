public class RemoveLinkedListElements {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
