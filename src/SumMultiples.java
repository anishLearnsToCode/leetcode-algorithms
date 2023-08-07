// https://leetcode.com/problems/sum-multiples
// T: O(1)
// S: O(1)

public class SumMultiples {
    public int sumOfMultiples(int n) {
        return 3 * summation(n / 3)
                + 5 * summation(n / 5)
                + 7 * summation(n / 7)
                - 15 * summation(n / 15)
                - 21 * summation(n / 21)
                - 35 * summation(n / 35)
                + 105 * summation(n / 105);
    }

    private int summation(int x) {
        return (x * (x + 1)) / 2;
    }
}
