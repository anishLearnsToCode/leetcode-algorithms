public class NumberOfRecentCalls {
    class RecentCounter {
        private Node head;
        private Node tail;
        private int size = 0;

        public int ping(int t) {
            size++;
            if (head == null) {
                head = new Node(t);
                tail = head;
            } else {
                tail.next = new Node(t);
                tail = tail.next;
            }
            while (head.val < t - 3000) {
                head = head.next;
                size--;
            }
            return size;
        }

        private class Node {
            int val;
            Node next;

            Node(final int val) {
                this.val = val;
            }
        }
    }
}
