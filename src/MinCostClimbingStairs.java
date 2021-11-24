public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int currentCost = cost[1], previousCost = cost[0], temp;
        for (int index = 2 ; index < cost.length ; index++) {
            temp = currentCost;
            currentCost = Math.min(currentCost, previousCost) + cost[index];
            previousCost = temp;
        }
        return Math.min(previousCost, currentCost);
    }
}
