// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i
// T: O(N^2)
// T: O(1)

public class MinimumSumOfMountainTripletsI {
    public int minimumSum(int[] array) {
        int minSum = Integer.MAX_VALUE;

        for (int i = 1 ; i < array.length - 1 ; i++) {
            final int minLeft = getSmallestOnLeft(array, i);
            if (minLeft >= array[i]) {
                continue;
            }
            final int minRight = getSmallestOnRight(array, i);
            if (minRight >= array[i]) {
                continue;
            }

            minSum = Math.min(minSum, minLeft + minRight + array[i]);
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    private static int getSmallestOnLeft(int[] array, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < index ; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    private static int getSmallestOnRight(int[] array, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = index + 1 ; i < array.length ; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
}
