// https://leetcode.com/problems/3sum-closest
// T: O(n^2)
// S: O(1)

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {0, 2, 1, -3}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i + 1, k = nums.length - 1 ; j < k ; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                else if (sum > target) k--;
                else j++;
            }
        }
        return closestSum;
    }
}
