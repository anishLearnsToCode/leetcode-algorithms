// https://leetcode.com/problems/find-the-highest-altitude
// T: O(N)
// S: O(1)

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gains) {
        int highestAltitude = 0, current = 0;
        for (int gain : gains) {
            current+= gain;
            highestAltitude = Math.max(highestAltitude, current);
        }
        return highestAltitude;
    }
}
