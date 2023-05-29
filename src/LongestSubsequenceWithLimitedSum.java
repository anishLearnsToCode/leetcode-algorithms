// https://leetcode.com/problems/longest-subsequence-with-limited-sum
// T: O((n + m) log(n))
// S: O(n)

import java.util.PriorityQueue;
import java.util.Queue;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        final int[] result = new int[queries.length];
        final int[] prefixSumArray = getMinSumArray(nums);

        for (int index = 0 ; index < queries.length ; index++) {
            int maxLen = binarySearch(prefixSumArray, queries[index]);
            if (maxLen < prefixSumArray.length && prefixSumArray[maxLen] == queries[index]) {
                result[index] = maxLen + 1;
            } else result[index] = maxLen;
        }

        return result;
    }

    private int binarySearch(int[] array, int x) {
        int left = 0, right = array.length - 1, index = 0;
        while (left <= right) {
            index = left + (right - left) / 2;
            if (array[index] == x) return index;
            else if (array[index] > x) right = index - 1;
            else left = index + 1;
        }
        return left;
    }

    private int[] getMinSumArray(int[] array) {
        final Queue<Integer> minHeap = new PriorityQueue<>();
        final int[] result = new int[array.length];
        for (int element : array) {
            minHeap.add(element);
        }
        result[0] = minHeap.poll();
        for (int index = 1 ; index < result.length ; index++) {
            result[index] = result[index - 1] + minHeap.poll();
        }
        return result;
    }
}
