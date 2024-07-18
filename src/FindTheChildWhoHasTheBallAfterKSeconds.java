// https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds
// T: O(1)
// S: O(1)

public class FindTheChildWhoHasTheBallAfterKSeconds {
    public int numberOfChild(int n, int k) {
        final boolean isLeftDirection = (k / (n - 1)) % 2 == 0;
        if (isLeftDirection) {
            return k % (n - 1);
        }
        return n - 1 - (k % (n - 1));
    }
}
