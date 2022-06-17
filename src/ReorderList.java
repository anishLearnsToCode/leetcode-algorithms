// https://leetcode.com/problems/reorder-list
// T: O(N)
// S: O(1)

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode middle = getMiddleOfLinkedList(head);
        ListNode preMiddle = reverseLinkedList(middle);
        interleaveNodes(head, preMiddle);
    }

    private ListNode getMiddleOfLinkedList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode preCurrent = head.next;
        while(preCurrent.next != null){
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = head.next;
            head.next = current;
        }
        return head;
    }

    // 1->2->3->6->5->4 to 1->6->2->5->3->4
    private void interleaveNodes(ListNode head, ListNode preMiddle) {
        ListNode p1 = head;
        ListNode p2 = preMiddle.next;
        while(p1 != preMiddle){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}
