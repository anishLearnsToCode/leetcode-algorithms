import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] array1, int[] array2) {
        Set<Integer> numbers1 = setFrom(array1);
        Set<Integer> numbers2 = setFrom(array2);
        return intersection(numbers1, numbers2);
    }

    private static int[] intersection(Set<Integer> numbers1, Set<Integer> numbers2) {
        List<Integer> result = new ArrayList<>();
        for (int element : numbers1) {
            if (numbers2.contains(element)) {
                result.add(element);
            }
        }
        return toArray(result);
    }

    private static int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int index = 0 ; index <list.size() ; index++) {
            array[index] = list.get(index);
        }
        return array;
    }

    private static Set<Integer> setFrom(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }
}
