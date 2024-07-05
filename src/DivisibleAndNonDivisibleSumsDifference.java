// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference
// T: O(N)
// S: O(1)

public class DivisibleAndNonDivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        final int sumDivisibleIntegers = getSumOfDivisibleIntegers(n, m);
        final int sumNonDivisibleIntegers = (n * (n + 1)) / 2 - sumDivisibleIntegers;

        return sumNonDivisibleIntegers - sumDivisibleIntegers;
    }

    private static int getSumOfDivisibleIntegers(int n, int m) {
        int sum = 0;
        for (int i = 1 ; i <= n ; i++) {
            if (i % m == 0) {
                sum += i;
            }
        }
        return sum;
    }
 }
