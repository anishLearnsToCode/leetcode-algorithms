// https://leetcode.com/problems/search-in-rotated-sorted-array-ii
// T: O(N)
// S: O(1)

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        for (int element : nums) {
            if (element == target) return true;
        }
        return false;
    }
}
