public class CountingBits {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        if (result.length > 1) result[1] = 1;
        for (int k = 2 ; k < result.length ; k *= 2) {
            for (int i = 0 ; i < k && i + k < result.length; i++) {
                result[k + i] = 1 + result[i];
            }
        }
        return result;
    }
}
