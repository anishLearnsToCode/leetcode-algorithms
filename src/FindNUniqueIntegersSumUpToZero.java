public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        final int[] result = new int[n];
        for (int i = 0, k = 1 ; i + 1 < result.length ; i += 2, k++) {
            result[i] = k;
            result[i + 1] = -k;
        }
        if ((n & 1) == 1) result[n - 1] = 0;
        return result;
    }
}
