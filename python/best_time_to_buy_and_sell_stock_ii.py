from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy_price, sell_price, profit = prices[0], prices[0], 0
        for price in prices:
            if price < sell_price:
                profit += sell_price - buy_price
                buy_price = price
                sell_price = price
            else:
                sell_price = price
        profit += sell_price - buy_price
        return profit
