// https://leetcode.com/problems/count-distinct-numbers-on-board
// T: O(1)
// S: O(1)

public class CountDistinctNumbersOnBoard {
    public int  distinctIntegers(int n) {
        if (n <= 2) return 0;
        return n - 1;
    }
}
