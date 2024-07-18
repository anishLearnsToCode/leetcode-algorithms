// https://leetcode.com/problems/special-array-i
// T: O(N)
// S: O(1)

public class SpecialArrayI {
    public boolean isArraySpecial(int[] array) {
        for (int i = 0 ; i < array.length - 1 ; i++) {
            if (array[i] % 2 == array[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }
}
