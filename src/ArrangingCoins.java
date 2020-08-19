public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int) Math.floor((Math.sqrt(8 * n + 1) - 1) / 2);
    }
}
