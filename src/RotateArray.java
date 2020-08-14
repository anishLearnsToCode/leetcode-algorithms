import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }

    public static void rotate(int[] array, int rotations) {
        rotations = rotations % array.length;
        int[] result = new int[array.length];
        for (int index = 0 ; index < array.length - rotations ; index++) {
            result[index + rotations] = array[index];
        }

        for (int index = array.length - rotations ; index < array.length ; index++) {
            result[index + rotations - array.length] = array[index];
        }

        for (int index = 0 ; index < array.length ; index++) {
            array[index] = result[index];
        }
    }
}
