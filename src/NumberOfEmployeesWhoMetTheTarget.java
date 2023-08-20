// https://leetcode.com/problems/number-of-employees-who-met-the-target
// T: O(N)
// S: O(1)

public class NumberOfEmployeesWhoMetTheTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int employeesWhoMetTarget = 0;
        for (int hour : hours) {
            if (hour >= target) {
                employeesWhoMetTarget++;
            }
        }
        return employeesWhoMetTarget;
    }
}
