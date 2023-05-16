// https://leetcode.com/problems/find-closest-number-to-zero
// T: O(N)
// S: O(1)

public class FindClosestNumberToZero {
    public int findClosestNumber(int[] array) {
        int nearest = Integer.MAX_VALUE;
        for (int element : array) {
            if (Math.abs(element) < Math.abs(nearest)) {
                nearest = element;
            } else if (Math.abs(element) == Math.abs(nearest)) {
                nearest = Math.max(nearest, element);
            }
        }

        return nearest;
    }
}
