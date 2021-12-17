import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanEqualToX {
    public int specialArray(int[] array) {
        Arrays.sort(array);
        int index = lastUniqueElementIndex(array);
        for (int pointer = array[index] ; array.length - index <= pointer ; ) {
            if (pointer == array.length - index) return pointer;
            pointer--;
            while (index > 0 && array[index - 1] >= pointer) index--;
        }
        return -1;
    }

    private int lastUniqueElementIndex(int[] array) {
        int index = array.length - 1;
        while (index - 1 >= 0 && array[index - 1] == array[index]) index--;
        return index;
    }
}
