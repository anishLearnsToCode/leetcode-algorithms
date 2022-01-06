// https://leetcode.com/problems/powx-n
// T: O(log(n))
// S: O(1)

public class Powxn {
    public double myPow(double x, int n) {
        if (n >= 0) return power(x, n);
        return 1 / power(x, -n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = power(x, n / 2);
        return half * half * (n % 2 == 0 ? 1 : x);
    }
}
