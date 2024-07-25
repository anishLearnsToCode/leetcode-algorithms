public class HelloWorld {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        createWeavedList(head);
        linkRandomPointersForNewNodes(head);
        return unweaveList(head);
    }

    // A->B->C --> A->A'->B->B'
    private static void createWeavedList(Node head) {
        for (Node i = head ; i != null ; i = i.next.next) {
            Node newNode = new Node(i.val);
            newNode.next = i.next;
            i.next = newNode;
        }
    }

    private static void linkRandomPointersForNewNodes(Node head) {
        for (Node i = head ; i != null ; i = i.next.next) {
            if (i.random == null) {
                continue;
            }
            i.next.random = i.random.next;
        }
    }

    private static Node unweaveList(Node head) {
        final Node pointerNew = head.next;
        for (Node old = head, i = head.next ; i != null && old != null ; i = i.next, old = old.next) {
            old.next = old.next == null ? null : old.next.next;
            i.next = i.next == null ? null : i.next.next;
        }
        return pointerNew;
    }
}
