// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i
// T: O(N)
// S: O(1)

public class MaximumNumberOfOperationsWithTheSameScoreI {
    public int maxOperations(int[] array) {
        int maxOperations = 1;
        for (int i = 2 ; i < array.length - 1 ; i += 2) {
            if ((array[i] + array[i + 1]) == (array[0] + array[1])) {
                maxOperations++;
            } else {
                break;
            }
        }
        return maxOperations;
    }
}
