// https://leetcode.com/problems/merge-intervals/submissions
// T: O(n log(n))
// S: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval  -> interval[0]));
        final List<int[]> mergedIntervals = new ArrayList<>();
        int start = intervals[0][0], stop = intervals[0][1];
        for (int i = 1 ; i < intervals.length ; i++) {
            if (intervals[i][0] <= stop) stop = Math.max(stop, intervals[i][1]);
            else {
                mergedIntervals.add(new int[] {start, stop});
                start = intervals[i][0];
                stop = intervals[i][1];
            }
        }
        mergedIntervals.add(new int[] {start, stop});
        return toArray(mergedIntervals);
    }

    private int[][] toArray(List<int[]> list) {
        int[][] result = new int[list.size()][2];
        int i = 0;
        for (int[] interval : list) {
            result[i++] = interval;
        }
        return result;
    }
}
