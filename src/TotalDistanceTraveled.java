// https://leetcode.com/problems/total-distance-traveled
// M = mainTank
// T: O(M)
// S: O(1)

public class TotalDistanceTraveled {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int totalDistance = 0;
        while (mainTank > 0) {
            if (mainTank >= 5) {
                mainTank -= 5;
                totalDistance += 50;
                if (additionalTank > 0) {
                    mainTank++;
                    additionalTank--;
                }
            } else {
                totalDistance += mainTank * 10;
                mainTank = 0;
            }
        }

        return totalDistance;
    }
}
