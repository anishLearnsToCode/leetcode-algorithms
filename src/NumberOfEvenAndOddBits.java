// https://leetcode.com/problems/number-of-even-and-odd-bits
// T: O(log(N))
// S: O(1)

public class NumberOfEvenAndOddBits {
    public int[] evenOddBit(int n) {
        return new int[] { evenBits(n), oddBits(n)};
    }

    private int evenBits(int x) {
        int bits = 0, num = 1;
        while (num <= x) {
            bits += (x & num) > 0 ? 1 : 0;
            num <<= 2;
        }
        return bits;
    }

    private int oddBits(int x) {
        int bits = 0, num = 2;
        while (num <= x) {
            bits += (x & num) > 0 ? 1 : 0;
            num <<= 2;
        }
        return bits;
    }
}
