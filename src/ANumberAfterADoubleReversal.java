// https://leetcode.com/problems/a-number-after-a-double-reversal
// T: O(1)
// S: O(1)

public class ANumberAfterADoubleReversal {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        return num % 10 != 0;
    }
}
