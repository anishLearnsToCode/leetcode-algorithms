import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int index = 0 ; index < nums.length ; index += 2) {
            result += Math.min(nums[index], nums[index + 1]);
        }
        return result;
    }
}
