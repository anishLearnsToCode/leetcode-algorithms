// https://leetcode.com/problems/minimum-bit-flips-to-convert-number
// T: O(log(n))
// S: O(1)

public class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        return hammingWeight(start ^ goal);
    }

    private int hammingWeight(int x) {
        int result = 0;
        while (x > 0) {
            x = x & (x - 1);
            result++;
        }
        return result;
    }
}
