import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] array) {
        int len = array.length;
        return (len * (len + 1)) / 2 - Arrays.stream(array).sum();
    }
}
