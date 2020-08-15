public class MoveZeros {
    public static void moveZeroes(int[] array) {
        int[] result = new int[array.length];
        for (int index = 0, j = 0 ; index < array.length ; index++) {
            if (array[index] != 0) {
                result[j++] = array[index];
            }
        }

        for (int index = 0 ; index < array.length ; index++) {
            array[index] = result[index];
        }
    }
}
