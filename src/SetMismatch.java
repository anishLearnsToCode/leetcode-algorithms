public class SetMismatch {
    public int[] findErrorNums(int[] array) {
        int repeated = 0, missing = 0;
        for (int number : array) {
            if (array[Math.abs(number) - 1] < 0) repeated = number;
            else array[Math.abs(number) - 1] *= -1;
        }
        for (int index = 0 ; index < array.length ; index++) {
            if (array[index] > 0) {
                missing = index + 1;
                break;
            }
        }
        return new int[] {Math.abs(repeated), missing};
    }
}
