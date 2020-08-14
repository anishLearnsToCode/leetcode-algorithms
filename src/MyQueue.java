import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    Queue<Integer> queue = new LinkedList<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
