import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] array) {
        Set<Integer> elements = new HashSet<>();
        for(int element : array) {
            if (elements.contains(element * 2) || (element % 2 == 0 && elements.contains(element / 2))) {
                return true;
            }
            elements.add(element);
        }
        return false;
    }
}
