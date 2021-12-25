import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        final List<Integer> indices = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == target) {
                indices.add(i);
            }
        }
        return indices;
    }
}
