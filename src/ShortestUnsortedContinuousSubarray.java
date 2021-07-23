public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, l = n, r = 0, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i] < max) r = i + 1;
            else max = nums[i];
            if (nums[n - 1 - i] > min) l = n - 1 - i - 1;
            else min = nums[n - 1 - i];
        }
        return Math.max(0, r - l - 1);
    }
}
