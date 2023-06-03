// https://leetcode.com/problems/minimum-cuts-to-divide-a-circle
// T: O(1)
// S: O(1)

public class MinimumCutsToDivideACircle {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        return n % 2 == 0 ? n / 2 : n;
    }
}
