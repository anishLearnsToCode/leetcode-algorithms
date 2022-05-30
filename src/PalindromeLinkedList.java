import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = listFrom(head);
        return isPalindrome(list);
    }

    private static boolean isPalindrome(List<Integer> list) {
        for (int index = 0 ; index < list.size() / 2 ; index++) {
            if (!list.get(index).equals(list.get(list.size() - 1 - index))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> listFrom(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
