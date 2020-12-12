public class NumberComplement {
    public static int findComplement(int n) {
        int numberOfBits = (int) (Math.floor(Math.log(n) / Math.log(2))) + 1;
        return ((1 << numberOfBits) - 1) ^ n;
    }
}
