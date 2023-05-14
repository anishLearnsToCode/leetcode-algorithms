// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount
// T: O(n log(n))
// S: O(log(n))

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;
        for (int index = cost.length - 1 ; index >= 0 ; index -= 3) {
            totalCost += cost[index] + (index - 1 >= 0 ? cost[index - 1] : 0);
        }
        return totalCost;
    }
}
