// https://leetcode.com/problems/insert-interval/submissions
// T: O(n)
// S: O(n)

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};
        final int startIndex = search(intervals, newInterval[0]);
        final int endIndex = search(intervals, newInterval[1]);
        final int newStart = startIndex >= intervals.length
                ? newInterval[0]
                : Math.min(intervals[startIndex][0], newInterval[0]);
        final int newEnd = endIndex >= intervals.length
                ? newInterval[1]
                : newInterval[1] >= intervals[endIndex][0] ? intervals[endIndex][1] : newInterval[1];
        final boolean hasMerged = hasMerged(intervals, newInterval, startIndex, endIndex);
        final int intervalMergedEnd = endIndex >= intervals.length
                ? intervals.length - 1
                : newInterval[1] >= intervals[endIndex][0] ? endIndex : endIndex - 1;
        final int intervalMergedStart = startIndex;
        final int elements = intervals.length - (hasMerged ? intervalMergedEnd - intervalMergedStart : -1);
        final int[][] result = new int[elements][2];
        int i = 0;
        for ( ; i < intervalMergedStart ; i++) result[i] = intervals[i];
        result[i++] = new int[] {newStart, newEnd};
        if (hasMerged) {
            for (i = intervalMergedEnd + 1 ; i < intervals.length ; i++) {
                result[i - (intervalMergedEnd - intervalMergedStart)] = intervals[i];
            }
        } else {
            for ( ; i < intervals.length ; i++) {
                result[i] = intervals[i - 1];
            }
        }
        return result;
    }

    private boolean hasMerged(int[][] intervals, int[] interval, int start, int end) {
        if (start >= intervals.length) return false;
        return interval[0] <= intervals[start][1] ||
                (end < intervals.length && interval[1] >= intervals[end][0]);
    }

    private int search(int[][] array, int x) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle][1] == x) return middle;
            else if (array[middle][1] > x) right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }
}
