// https://leetcode.com/problems/sort-colors
// T: O(n) single pass solution
// S: O(1)

public class SortColors {
    public void sortColors(int[] nums) {
        int zerosIndex = 0;
        int onesIndex = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            int temp = nums[i];
            nums[i] = 2;
            if (temp == 0) {
                nums[onesIndex++] = 1;
                nums[zerosIndex++] = 0;
            } else if (temp == 1) {
                nums[onesIndex++] = 1;
            }
        }
    }
}
