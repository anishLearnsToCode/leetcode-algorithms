public class NumberComplement {
    public static int findComplement(int number) {
        return ~number & (Integer.highestOneBit(number) - 1);
    }
}
