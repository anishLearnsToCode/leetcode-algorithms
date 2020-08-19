import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] array) {
        Arrays.sort(array);
        int count = 0;
        Set<Integer> numbers = new HashSet<>();
        for (int index = array.length - 1 ; index >= 0 ; index--) {
            int element = array[index];
            if (!numbers.contains(element)) {
                if (count == 2) {
                    return element;
                }
                count++;
                numbers.add(element);
            }
        }
        return array[0];
    }
}
