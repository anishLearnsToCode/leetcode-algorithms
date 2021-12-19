import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        final Queue<Integer> studentQueue = queueFrom(students);
        int replacementStudents = 0, stack = 0;
        while (!studentQueue.isEmpty() && replacementStudents < studentQueue.size()) {
            if (studentQueue.peek() == sandwiches[stack]) {
                stack++;
                studentQueue.poll();
                replacementStudents = 0;
            } else {
                studentQueue.add(studentQueue.poll());
                replacementStudents++;
            }
        }
        return studentQueue.size();
    }

    private Queue<Integer> queueFrom(int[] array) {
        final Queue<Integer> queue = new LinkedList<>();
        for (int element : array) {
            queue.add(element);
        }
        return queue;
    }
}
