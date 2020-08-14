import java.util.HashSet;
import java.util.Set;

public class IntersectionOf2LinkedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aNodes = new HashSet<>();
        while (headA != null) {
            aNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (aNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
