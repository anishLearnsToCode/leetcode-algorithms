// https://leetcode.com/problems/gas-station
// T: O(n)
// S: O(1)

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) return -1;

        int startIndex = 0;
        for (int i = 0, total = 0 ; i < gas.length ; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                startIndex = i + 1;
            }
        }
        return startIndex;
    }

    private int sum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }
}
