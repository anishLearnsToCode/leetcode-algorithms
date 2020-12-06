import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int minimumValue = Arrays.stream(nums).min().getAsInt();
        return sum - minimumValue * nums.length;
    }
}
