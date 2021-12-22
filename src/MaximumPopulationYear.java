// https://leetcode.com/problems/maximum-population-year
// T: O(N)
// S: O(1)

public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        final int[] population = new int[101];
        for (int[] log : logs) {
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }
        return maxIndexOfRunningSum(population) + 1950;
    }

    private int maxIndexOfRunningSum(int[] array) {
        int maxIndex = 0;
        for (int index = 1, current = array[0], maxVal = current ; index < array.length ; index++) {
            current += array[index];
            if (current > maxVal) {
                maxVal = current;
                maxIndex = index;
            }
        }
        return maxIndex;
    }
}
