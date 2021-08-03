public class NonDecreasingArray {
    public boolean checkPossibility(int[] array) {
        boolean handledDecreasing = false;
        for (int index = 0 ; index < array.length - 1 ; index++) {
            if (array[index] > array[index + 1]) {
                if (handledDecreasing) return false;
                handledDecreasing = true;
                if ((index - 1 >= 0 && array[index - 1] > array[index + 1]) && (index + 2 < array.length && array[index] > array[index + 2])) {
                    return false;
                }
            }
        }
        return true;
    }
}
