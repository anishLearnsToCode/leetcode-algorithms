// https://leetcode.com/problems/longest-increasing-subsequence
// T: O(NlogN)
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        final List<Integer> tail = new ArrayList<>();
        int maxLength = 1;
        tail.add(nums[0]);

        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > tail.get(maxLength - 1)) {
                tail.add(nums[i]);
                maxLength++;
            } else if (nums[i] < tail.get(0)) {
                tail.set(0, nums[i]);
            } else {
                int insertionIndex = binarySearch(tail, nums[i]);
                tail.set(insertionIndex, nums[i]);
            }
        }

        return maxLength;
    }

    private static int binarySearch(List<Integer> array, int x) {
        int left = 0, right = array.size(), middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array.get(middle) == x) return middle;
            else if (array.get(middle) < x) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }
}
