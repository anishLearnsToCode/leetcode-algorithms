import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloWorld {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }

        final int startIndex = binarySearch(intervals, newInterval[0]);

        final List<int[]> result = new ArrayList<>();
        for (int i = 0 ; i < startIndex ; i++) {
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for (int i = startIndex ; i < intervals.length ; i++) {
            result.add(intervals[i]);
        }

        return mergeIntervals(result);
    }

    private static int[][] mergeIntervals(List<int[]> intervals) {
        final List<int[]> result = new ArrayList<>();
        int start = intervals.getFirst()[0], end = intervals.getFirst()[1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[] { start, end });
        return toArray(result);
    }

    private static int binarySearch(int[][] intervals, int x) {
        int left = 0, right = intervals.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (intervals[middle][0] == x) return middle;
            else if (intervals[middle][0] < x) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }

    private static int[][] toArray(List<int[]> intervals) {
        final int[][] result = new int[intervals.size()][2];
        int k = 0;
        for (int[] interval : intervals) {
            result[k++] = interval;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(
//                insert(new int[][]{{1, 3}, {6, 9}}, new int[] {2, 5})
//        ));

//        System.out.println(Arrays.deepToString(
//                insert(
//                        new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
//                        new int[] {4, 8}
//                )
//        ));

        System.out.println(Arrays.deepToString(
                insert(
                        new int[][] {{1, 3}, {6, 9}},
                        new int[] {2, 5}
                )
        ));
    }
}
