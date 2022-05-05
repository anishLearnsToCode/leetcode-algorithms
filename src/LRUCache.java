// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int value;
        Node next;
        Node previous;

        Node() { }
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if(node == null) {
            Node newNode = new Node(key, value);
            this.cache.put(key, newNode);
            this.addNode(newNode);

            if(cache.size() > capacity){
                Node tail = popTail();
                this.cache.remove(tail.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Node popTail(){
        Node res = tail.previous;
        this.removeNode(res);
        return res;
    }

    private void addNode(Node node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node pre = node.previous;
        Node post = node.next;
        pre.next = post;
        post.previous = pre;
    }

    private void moveToHead(Node node){
        this.removeNode(node);
        this.addNode(node);
    }
}
