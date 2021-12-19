import java.util.Arrays;

public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        final int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int index = 2 ; index < array.length ; index++) {
            if ((index & 1) == 0) array[index] = array[index / 2];
            else array[index] = array[index / 2] + array[index - index / 2];
        }
        return Arrays.stream(array).max().getAsInt();
    }
}
