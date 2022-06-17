// https://leetcode.com/problems/insertion-sort-list
// T: O(n^2)
// S: O(1)

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        ListNode next;

        for (ListNode cur = head ; cur != null ; ) {
            next = cur.next;

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = newHead;
            cur = next;
        }

        return newHead.next;
    }
}
