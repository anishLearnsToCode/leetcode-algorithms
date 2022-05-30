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
}
