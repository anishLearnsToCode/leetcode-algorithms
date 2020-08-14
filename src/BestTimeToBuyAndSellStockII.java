public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int sellPrice = prices[0];
        int buyPrice = prices[0];
        int profit = 0;

        for (int index = 1 ; index <prices.length ; index++) {
            if (prices[index] < sellPrice) {
                profit += sellPrice - buyPrice;
                sellPrice = buyPrice = prices[index];
            } else {
                sellPrice = prices[index];
            }
        }
        profit += sellPrice - buyPrice;

        return profit;
    }
}
