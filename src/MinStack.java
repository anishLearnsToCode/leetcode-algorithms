import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private final List<Integer> numbers = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        numbers.add(x);
    }

    public void pop() {
        numbers.remove(numbers.size() - 1);
    }

    public int top() {
        return numbers.get(numbers.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int element : numbers) {
            min = Math.min(min, element);
        }
        return min;
    }
}
