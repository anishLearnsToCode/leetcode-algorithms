import java.util.HashSet;
import java.util.Set;

public class IntersectionOf2LinkedLists {

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
