import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final Map<Integer,Integer> elementWeight = new HashMap<>();
        for (int i = 0 ; i < arr2.length ; i++) elementWeight.put(arr2[i], i);
        Integer[] array = arrayFrom(arr1);
        Arrays.sort(array, (o1, o2) -> {
            if (elementWeight.containsKey(o1) && elementWeight.containsKey(o2)) {
                return elementWeight.get(o1) - elementWeight.get(o2);
            }
            if (elementWeight.containsKey(o1)) {
                return -1;
            }
            if (elementWeight.containsKey(o2)) {
                return 1;
            }
            return Integer.compare(o1, o2);
        });
        return toIntArray(array);
    }

    private Integer[] arrayFrom(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int index = 0 ; index < array.length ; index++) {
            result[index] = array[index];
        }
        return result;
    }

    private int[] toIntArray(Integer[] array) {
        int[] result = new int[array.length];
        for (int index = 0 ; index < array.length ; index++) {
            result[index] = array[index];
        }
        return result;
    }
}
