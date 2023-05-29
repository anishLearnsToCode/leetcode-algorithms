import java.util.PriorityQueue;
import java.util.Queue;

public class HelloWorld {
    public static void main(String[] args) {
        final Queue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(4);
        queue.add(-2);

        System.out.println(queue.peek());
    }
}
