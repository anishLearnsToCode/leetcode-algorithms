public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] array) {
        for (int i = 0 ; i < array.length - 2 ; i++) {
            if (isOdd(array[i]) && isOdd(array[i + 1]) && isOdd(array[i + 2])) {
                return true;
            }
        }
        return false;
    }

    private boolean isOdd(int x) {
        return (x & 1) == 1;
    }
}
