// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i
// T: O(N)
// S: O(1)

public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public int minimumCost(int[] array) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] < smallest) {
                secondSmallest = smallest;
                smallest = array[i];
            } else if (array[i] < secondSmallest) {
                secondSmallest = array[i];
            }
        }
        return array[0] + smallest + secondSmallest;
    }
}
