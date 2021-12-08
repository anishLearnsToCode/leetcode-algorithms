public class ConvertBinaryNumberInLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int value = 0;
        while (head != null) {
            value <<= 1;
            value += head.val;
            head = head.next;
        }
        return value;
    }


     private static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
