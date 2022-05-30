// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
// T: O(N)
// S: O(1)

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        int val;
        for (ListNode current = head, previous = tempHead ; current != null && current.next != null ; ) {
            if (current.val == current.next.val) {
                val = current.val;
                while (current.next != null && current.next.val == val) {
                    current = current.next;
                }
                current = current.next;
                previous.next = current;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return tempHead.next;
    }
}
