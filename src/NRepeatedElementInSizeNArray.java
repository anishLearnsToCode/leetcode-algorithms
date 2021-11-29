public class NRepeatedElementInSizeNArray {
    public int repeatedNTimes(int[] nums) {
        for (int k = 1 ; k < 4 ; k++) {
            for (int i = 0 ; i < nums.length - k ; i++) {
                if (nums[i] == nums[i + k]) return nums[i];
            }
        }
        return -1;
    }
}
