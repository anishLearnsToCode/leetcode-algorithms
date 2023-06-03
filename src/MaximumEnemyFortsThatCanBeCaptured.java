// https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured
// T: O(N)
// S: O(1)

public class MaximumEnemyFortsThatCanBeCaptured {
    public int captureForts(int[] forts) {
        int last1 = Integer.MAX_VALUE, last_1 = Integer.MAX_VALUE, maxCapture = 0, previous = 0;
        for (int index = 0 ; index < forts.length ; index++) {
            if (forts[index] == 1) {
                if (last_1 != Integer.MAX_VALUE && previous == -1) {
                    maxCapture = Math.max(maxCapture, index - last_1 - 1);
                }
                previous = 1;
                last1 = index;
            } else if (forts[index] == -1) {
                if (last1 != Integer.MAX_VALUE && previous == 1) {
                    maxCapture = Math.max(maxCapture, index - last1 - 1);
                }
                previous = -1;
                last_1 = index;
            }
        }
        return maxCapture;
    }
}
