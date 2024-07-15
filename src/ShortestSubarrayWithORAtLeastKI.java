// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i
// T: O(N^2)
// S: O(1)

public class ShortestSubarrayWithORAtLeastKI {
    public int minimumSubarrayLength(int[] array, int k) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0 ; i < array.length ; i++) {
            int current = array[i];
            for (int j = i ; j < array.length ; j++) {
                current |= array[j];
                if (current >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
