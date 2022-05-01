// T: O(n)
// S: O(n)

public class FlattenAMultiLevelDoublyLinkedList {
    private static final class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        for (Node temp = head ; temp != null ; temp = temp.next) {
            if (temp.child != null) {
                Node lastNodeOfFlattenedChildren = flattenLinkedList(temp.child);
                lastNodeOfFlattenedChildren.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = lastNodeOfFlattenedChildren;
                }
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
        }
        return head;
    }

    private Node flattenLinkedList(Node head) {
        Node temp = head;
        for (; temp.next != null ; temp = temp.next) {
            if (temp.child != null) {
                Node lastNodeOfFlattenedChildren = flattenLinkedList(temp.child);
                lastNodeOfFlattenedChildren.next = temp.next;
                temp.next.prev = lastNodeOfFlattenedChildren;
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
        }
        if (temp.child != null) {
            Node lastNodeOfFlattenedChildren = flattenLinkedList(temp.child);
            temp.next = temp.child;
            temp.child.prev = temp;
            temp.child = null;
            return lastNodeOfFlattenedChildren;
        }
        return temp;
    }
}
