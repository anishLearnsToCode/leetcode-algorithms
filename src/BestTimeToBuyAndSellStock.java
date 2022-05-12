// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
// T: O(n)
// S: O(1)

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int buyPrice = prices[0];
        int profit = 0;
        for (int index = 1 ; index < prices.length ; index++) {
            profit = Math.max(profit, prices[index] - buyPrice);
            buyPrice = Math.min(buyPrice, prices[index]);
        }
        return profit;
    }
}
