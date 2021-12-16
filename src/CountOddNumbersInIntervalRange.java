public class CountOddNumbersInIntervalRange {
    public int countOdds(int low, int high) {
        final int count = high - low + 1;
        if ((count & 1) == 0) return count / 2;
        return count / 2 + (low & 1);
    }
}
