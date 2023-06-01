// https://leetcode.com/problems/number-of-common-factors
// T: O(min(a, b))
// S: O(1)

public class NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        final int min = Math.min(a, b);
        int commonFactors = 1;

        for (int factor = 2 ; factor <= min ; factor++) {
            if (a % factor == 0 & b % factor == 0) {
                commonFactors++;
            }
        }
        return commonFactors;
    }
}
