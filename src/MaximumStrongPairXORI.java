// https://leetcode.com/problems/maximum-strong-pair-xor-i
// T: O(N^2)
// S: O(1)

import java.util.Arrays;

public class MaximumStrongPairXORI {
    public int maximumStrongPairXor(int[] array) {
        int result = 0;

        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i ; j < array.length ; j++) {
                if (Math.abs(array[i] - array[j]) <= Math.min(array[i], array[j])) {
                    result = Math.max(result, array[i] ^ array[j]);
                }
            }
        }

        return result;
    }
}
