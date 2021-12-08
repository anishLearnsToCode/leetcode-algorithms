public class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] array) {
        if (array.length <= 3) return array[0];
        final int specialIntegerFrequency = array.length / 4 + 1;
        for (int i = 1, current = 1 ; i < array.length ; i++) {
            if (array[i] ==array[i - 1]) current++;
            else current = 1;

            if (current >= specialIntegerFrequency) return array[i];
        }
        return -1;
    }
}
