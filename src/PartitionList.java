// https://leetcode.com/problems/partition-list
// T: O(N)
// S: O(1)

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(), beforeTemp = beforeHead;
        ListNode afterHead = new ListNode(), afterTemp = afterHead;
        while (head != null) {
            if (head.val < x) {
                beforeTemp.next = head;
                beforeTemp = beforeTemp.next;
            } else {
                afterTemp.next = head;
                afterTemp = afterTemp.next;
            }
            head = head.next;
        }
        afterTemp.next = null;
        beforeTemp.next = afterHead.next;
        return beforeHead.next;
    }
}
