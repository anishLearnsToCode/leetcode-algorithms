import java.util.LinkedList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> queue = new LinkedList<>();
        for (String operation : ops) {
            if (operation.equals("+")) {
                queue.add(queue.get(queue.size() - 1) + queue.get(queue.size() - 2));
            } else if (operation.equals("D")) {
                queue.add(queue.get(queue.size() - 1) * 2);
            } else if (operation.equals("C")) {
                queue.remove(queue.size() - 1);
            } else {
                queue.add(Integer.valueOf(operation));
            }
        }
        return sum(queue);
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int element : list) {
            sum += element;
        }
        return sum;
    }
}
