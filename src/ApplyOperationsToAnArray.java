// https://leetcode.com/problems/apply-operations-to-an-array
// T: O(N)
// S: O(N)

public class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] array) {
        final int[] result = new int[array.length];
        int j = 0;
        for (int i = 0, previous = array[0] ; i < array.length - 1 ; i++) {
            if (previous == 0) {
                previous = array[i + 1];
                continue;
            }

            if (previous == array[i + 1]) {
                result[j++] = 2 * array[i];
                previous = 0;
                continue;
            }

            result[j++] = array[i];
            previous = array[i + 1];
        }

        if (array[array.length - 2] != array[array.length - 1]) {
            result[j] = array[array.length - 1];
        }

        return result;
    }
}
