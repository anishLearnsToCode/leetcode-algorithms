// https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal
// T: O(max(log(N), log(K)))
// S: O(1)

public class NumberOfBitChangesToMakeTwoIntegersEqual {
    public int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }

        int changes = 0;
        while (n > 0 || k > 0) {
            final int nLastBit = n & 1;
            final int kLastBit = k & 1;
            if (kLastBit == 1 && nLastBit == 0) {
                return -1;
            } else if (kLastBit == 0 && nLastBit == 1) {
                changes++;
            }
            n >>= 1;
            k >>= 1;
        }
        return changes;
    }
}
