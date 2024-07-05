// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i
// T: O(N^2)
// S: O(1)

public class FindIndicesWithIndexAndValueDifferenceI {
    public int[] findIndices(int[] array, int indexDifference, int valueDifference) {
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i + indexDifference ; j < array.length ; j++) {
                if (Math.abs(array[i] - array[j]) >= valueDifference) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1};
    }
}
