// https://leetcode.com/problems/linked-list-cycle-ii
// T: O(n)
// S: O(1)

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head, entry = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}
