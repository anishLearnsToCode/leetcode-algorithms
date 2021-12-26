import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        final Set<List<Integer>> quadruplets = new HashSet<>();

        for (int a = 0 ; a < nums.length - 3 ; a++) {
            for (int b = a + 1 ; b < nums.length - 2 ; b++) {
                for (int c = b + 1, d = nums.length - 1 ; c < d ; ) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) quadruplets.add(List.of(nums[a], nums[b], nums[c++], nums[d--]));
                    else if (sum < target) c++;
                    else d--;
                }
            }
        }

        return new ArrayList<>(quadruplets);
    }
}
