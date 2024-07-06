// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros
// T: O(N)
// S: O(1)

public class CheckIfBitwiseORHasTrailingZeros {
    public boolean hasTrailingZeros(int[] array) {
        int evenNumbers = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                evenNumbers++;
            }
            if (evenNumbers == 2) {
                return true;
            }
        }
        return false;
    }
}
