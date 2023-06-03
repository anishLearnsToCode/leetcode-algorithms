// https://leetcode.com/problems/find-the-pivot-integer
// T: O(N)
// S: O(1)

public class FindThePivotInteger {
    public int pivotInteger(int n) {
        for (int pivot = 1, left = 1, right = summation(n) ; pivot <= n ; pivot++) {
            if (left == right) return pivot;
            if (left > right) break;
            left += pivot + 1;
            right -= pivot;
        }
        return -1;
    }

    private int summation(int n) {
        return (n * (n + 1)) / 2;
    }
}
