import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private final List<Integer> numbers = new ArrayList<>(1000);

    public void push(int x) {
        numbers.add(x);
    }

    public int pop() {
        int element = numbers.get(numbers.size() - 1);
        numbers.remove(numbers.size() - 1);
        return element;
    }

    public int top() {
        return numbers.get(numbers.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return numbers.isEmpty();
    }
}