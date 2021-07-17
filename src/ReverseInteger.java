// https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0, next;
        boolean isPositive = x >= 0;
        x = isPositive ? x : -x;
        while (x > 0) {
            next = 10 * result + x % 10;
            if (next / 10 != result) {
                return 0;
            }
            result = next;
            x /= 10;
        }
        return isPositive ? result : -result;
    }
}
