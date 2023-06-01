// https://leetcode.com/problems/smallest-even-multiple
// T: O(1)
// S: O(1)

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) return n;
        return n * 2;
    }
}
