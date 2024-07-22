import java.util.Arrays;

public class HelloWorld {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        final int totalGas = Arrays.stream(gas).sum();
        final int totalCost = Arrays.stream(cost).sum();

        if (totalCost > totalGas) {
            return -1;
        }

        int startingIndex = 0;
        for (int i = 0, currentGas = 0 ; i < cost.length ; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startingIndex = i + 1;
            }
        }
        return startingIndex;
    }
}