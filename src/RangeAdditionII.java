public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] operations) {
        for (int[] operation : operations) {
            m = Math.min(m, operation[0]);
            n = Math.min(n, operation[1]);
        }
        return m * n;
    }
}
