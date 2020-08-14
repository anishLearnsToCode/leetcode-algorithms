import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int element : array) {
            if (numbers.contains(element)) {
                numbers.remove(element);
            } else {
                numbers.add(element);
            }
        }

        for (int number : numbers) {
            return number;
        }
        return -1;
    }
}
