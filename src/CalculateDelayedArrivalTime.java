// https://leetcode.com/problems/calculate-delayed-arrival-time
// T: O(1)
// S: O(1)

public class CalculateDelayedArrivalTime {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
