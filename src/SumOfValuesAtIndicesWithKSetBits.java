// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits
// T: O(N)
// S: O(1)

import java.util.List;

public class SumOfValuesAtIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> array, int k) {
        int sum = 0;
        for (int i = 0 ; i < array.size() ; i++) {
            if (numberOfSetBits(i) == k) {
                sum += array.get(i);
            }
        }
        return sum;
    }

    private static int numberOfSetBits(int number) {
        int setBits = 0;
        while (number > 0) {
            setBits += number % 2;
            number /= 2;
        }
        return setBits;
    }
}
