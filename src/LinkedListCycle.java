// T: O(n)
// S: O(1)

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        for (ListNode slow = head, fast = head.next; fast != null && fast.next != null ; ) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
