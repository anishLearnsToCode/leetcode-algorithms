public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] array) {
        int slope = 0;
        for (int index = 0 ; index < array.length - 1 ; index++) {
            if (array[index] > array[index + 1]) slope++;
        }
        return slope == 0 || (slope == 1 && array[array.length - 1] <= array[0]);
    }
}
