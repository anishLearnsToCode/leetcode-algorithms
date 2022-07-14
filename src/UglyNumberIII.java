// https://leetcode.com/problems/ugly-number-iii
// T: O(log(MAX_VAL)) MAX_VAL = Integer.MAX_VAL here
// S: O(1)

public class UglyNumberIII {
    private long a;
    private long b;
    private long c;
    private long lcm_a_b;
    private long lcm_a_c;
    private long lcm_b_c;
    private long lcm_a_b_c;

    public int nthUglyNumber(int n, int a, int b, int c) {
        setValues(a, b, c);
        int left = 1, right = Integer.MAX_VALUE, middle;
        long factors;
        while (left <= right) {
            middle = left + (right - left) / 2;
            factors = numberOfFactors(middle);
            if (factors >= n) right = middle - 1;
            else left = middle + 1;
        }
        return left;
    }

    private void setValues(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.lcm_a_b = lcm(a, b);
        this.lcm_a_c = lcm(a, c);
        this.lcm_b_c = lcm(b, c);
        this.lcm_a_b_c = lcm(lcm_a_b, c);
    }

    /*
    * @param n number
    * @return will tell how many factors are there of a, b and c between 1 and n
    *           e.g. if n=10 and a=2 b=3 so there are 7 factors {2, 3, 4, 6, 8, 9, 10}
     */
    private long numberOfFactors(int n) {
        return n / a
               + n / b
               + n / c
               - n / lcm_a_b
               - n / lcm_a_c
               - n / lcm_b_c
               + n / lcm_a_b_c;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
