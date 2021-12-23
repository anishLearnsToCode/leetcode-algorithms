// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered
// T:O(|ranges| + |right - left|)
// S: O(1)

public class CheckIfAllTheIntegersInARangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        final int[] covered = new int[51];
        for (int[] range : ranges) {
            covered[range[0] - 1]++;
            covered[range[1]]--;
        }
        final int[] isCovered = runningSum(covered);
        for (int i = left ; i <= right ; i++) {
            if(isCovered[i - 1] <= 0) return false;
        }
        return true;
    }

    private static int[] runningSum(int[] array) {
        final int[] sum = new int[array.length];
        sum[0] = array[0];
        for (int i = 1 ; i < array.length ; i++) {
            sum[i] = sum[i - 1] + array[i];
        }
        return sum;
    }
}
