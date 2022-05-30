public class DeleteANodeInLinkedList {

    public static void deleteNode(ListNode node) {
        ListNode current = node;
        while (current != null && current.next != null && current.next.next != null) {
            current.val = current.next.val;
            current = current.next;
        }
        current.val = current.next.val;
        current.next = null;
    }
}
