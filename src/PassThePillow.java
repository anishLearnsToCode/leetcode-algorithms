// https://leetcode.com/problems/pass-the-pillow
// T: O(1)
// S: O(1)

public class PassThePillow {
    public int passThePillow(int n, int time) {
        final int direction = (int) Math.ceil((double) time / (n - 1));
        final int multiplier = direction % 2 == 0 ? -1 : 1;
        final int steps = time - (direction - 1) * (n - 1);
        if (multiplier == 1) {
            return steps + 1;
        }
        return n - steps;
    }
}
