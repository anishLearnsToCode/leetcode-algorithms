// https://leetcode.com/problems/copy-list-with-random-pointer
// T: O(N)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    private static final class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public HelloWorld.Node copyRandomList(HelloWorld.Node head) {
        if (head == null) {
            return null;
        }

        createWeavedList(head);
        linkRandomPointersForNewNodes(head);
        return unweaveList(head);
    }

    // A->B->C --> A->A'->B->B'
    private static void createWeavedList(HelloWorld.Node head) {
        for (HelloWorld.Node i = head; i != null ; i = i.next.next) {
            HelloWorld.Node newNode = new HelloWorld.Node(i.val);
            newNode.next = i.next;
            i.next = newNode;
        }
    }

    private static void linkRandomPointersForNewNodes(HelloWorld.Node head) {
        for (HelloWorld.Node i = head; i != null ; i = i.next.next) {
            if (i.random == null) {
                continue;
            }
            i.next.random = i.random.next;
        }
    }

    private static HelloWorld.Node unweaveList(HelloWorld.Node head) {
        final HelloWorld.Node pointerNew = head.next;
        for (HelloWorld.Node old = head, i = head.next; i != null && old != null ; i = i.next, old = old.next) {
            old.next = old.next == null ? null : old.next.next;
            i.next = i.next == null ? null : i.next.next;
        }
        return pointerNew;
    }
}
