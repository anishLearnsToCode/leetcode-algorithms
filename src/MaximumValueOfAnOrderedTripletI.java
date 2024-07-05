// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i
// T: O(N^3)
// S: O(1)

public class MaximumValueOfAnOrderedTripletI {
    public long maximumTripletValue(int[] array) {
        long result = 0;
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i + 1 ; j < array.length ; j++) {
                for (int k = j + 1 ; k < array.length ; k++) {
                    result = Math.max(result, (long) (array[i] - array[j]) * array[k]);
                }
            }
        }

        return result;
    }
}
