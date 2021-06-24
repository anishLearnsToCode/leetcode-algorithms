from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit, buy_price = 0, prices[0]
        for price in prices:
            max_profit = max(max_profit, price - buy_price)
            buy_price = min(buy_price, price)
        return max_profit
