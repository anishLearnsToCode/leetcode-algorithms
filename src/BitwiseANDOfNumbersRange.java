// https://leetcode.com/problems/bitwise-and-of-numbers-range
// T: O(log(left))
// S: O(1)

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int moveFactor = 0;
        while(left != right){
            left >>= 1;
            right >>= 1;
            moveFactor++;
        }

        return left << moveFactor;
    }
}
