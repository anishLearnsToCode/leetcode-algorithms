// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
// T: O(N)
// S: O(1)

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int insertionIndex = 1;
        for (int i = 1, count = 1 ; i < nums.length ; i++) {
            if (nums[i] == nums[insertionIndex - 1]) {
                if (count == 2) continue;
                nums[insertionIndex++] = nums[i];
                count++;
            } else {
                nums[insertionIndex++] = nums[i];
                count = 1;
            }
        }
        return insertionIndex;
    }
}
