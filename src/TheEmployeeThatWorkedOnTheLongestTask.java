// https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task
// T: O(|logs|)
// S: O(1)

public class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int longestTime = -1, employeeId = -1, previousTime = 0;
        for (int[] log : logs) {
            int time = log[1] - previousTime;
            previousTime = log[1];
            if (time > longestTime) {
                longestTime = time;
                employeeId = log[0];
            } else if (time == longestTime && log[0] < employeeId) {
                employeeId = log[0];
            }
        }
        return employeeId;
    }
}
