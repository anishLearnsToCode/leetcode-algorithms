// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> cache = new HashMap<>();
    private final int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        final Node node = cache.get(key);
        moveNodeToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveNodeToTail(node);
        } else if (cache.size() == capacity) {
            Node node = new Node(key, value);
            cache.put(key, node);
            cache.remove(head.key);
            appendToTail(node);
            popHead();
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);

            if (cache.size() == 1) {
                head = node;
                tail = node;
            } else {
                appendToTail(node);
            }
        }
    }

    private void moveNodeToTail(Node node) {
        if (node == tail) {
            return;
        }

        if (node == head) {
            appendToTail(node);
            popHead();
            return;
        }

        Node previous = node.previous, next = node.next;
        previous.next = next;
        next.previous = previous;

        appendToTail(node);
    }

    private void appendToTail(Node node) {
        tail.next = node;
        node.previous = tail;
        tail = node;
    }

    private void popHead() {
        head = head.next;
        head.previous = null;
    }
}