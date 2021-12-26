import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public  List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        final Set<List<Integer>> triplets = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1 ; j < k ; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) triplets.add(List.of(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else j++;
            }
        }

        return new ArrayList<>(triplets);
    }
}
