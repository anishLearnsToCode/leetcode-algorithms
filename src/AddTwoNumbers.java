// https://leetcode.com/problems/add-two-numbers
// T: O(max(|l1|, |l2|))
// S: O(max(|l1|, |l2|))

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            current.next = new ListNode();
            current = current.next;
            int sum = get(l1) + get(l2) + carry;
            current.val = sum % 10;
            carry = sum / 10;
            l1 = next(l1);
            l2 = next(l2);
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    private ListNode next(ListNode node) {
        if (node == null) return null;
        return node.next;
    }

    private int get(ListNode node) {
        if (node == null) return 0;
        return node.val;
    }
}
