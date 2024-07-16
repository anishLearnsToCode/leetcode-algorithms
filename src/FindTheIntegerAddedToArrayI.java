// https://leetcode.com/problems/find-the-integer-added-to-array-i
// T: O(N)
// S: O(1)

public class FindTheIntegerAddedToArrayI {
    public int addedInteger(int[] array1, int[] array2) {
        final int min1 = smallestElement(array1);
        final int min2 = smallestElement(array2);
        return min2 - min1;
    }

    private static int smallestElement(int[] array) {
        int result = Integer.MAX_VALUE;
        for (int element : array) {
            result = Math.min(result, element);
        }
        return result;
    }
}
