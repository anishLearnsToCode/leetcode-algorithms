// https://leetcode.com/problems/count-operations-to-obtain-zero
// T: O(max(a, b))
// S: O(1)

public class CountOperationsToObtainZero {
    public int countOperations(int num1, int num2) {
        int operations = 0;
        while (num1 != 0 && num2 != 0) {
            operations++;
            if (num1 >= num2) {
                num1 -= num2;
            } else num2 -= num1;
        }
        return operations;
    }
}
