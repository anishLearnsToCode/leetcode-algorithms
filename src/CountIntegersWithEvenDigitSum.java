// https://leetcode.com/problems/count-integers-with-even-digit-sum
// T: O(1)
// S: O(1)

public class CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        final int group = num / 10;
        return 5 * group - 1 + (num % 10 + 1 + series(group)) / 2;
    }

    private int series(int group) {
        return (group % 10 + (group % 100) / 10 + (group % 1000) / 100 + 1) % 2;
    }
}
