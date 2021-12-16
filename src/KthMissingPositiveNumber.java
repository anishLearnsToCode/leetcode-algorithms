// https://leetcode.com/problems/kth-missing-positive-number
// T: O(n)
// S: O(1)

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int pointer = 1, missing = 0;
        for (int index = 0, current = arr[index]; missing < k ; ) {
            if (pointer < current) {
                missing++;
            } else {
                index++;
                current = index == arr.length ? Integer.MAX_VALUE : arr[index];
            }
            pointer++;
        }
        return pointer - 1;
    }
}
