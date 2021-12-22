// https://leetcode.com/problems/sign-of-the-product-of-an-array
// T: O(N)
// S: O(1)

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int element : nums) {
            sign *= signum(element);
        }
        return sign;
    }

    private int signum(int x) {
        if (x == 0) return 0;
        return x > 0 ? 1 : -1;
    }
}
