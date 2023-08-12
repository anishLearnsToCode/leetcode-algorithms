// https://leetcode.com/problems/buy-two-chocolates
// T: O(N)
// S: O(1)

public class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int minimum = Integer.MAX_VALUE, secondMinimum = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price <= minimum) {
                secondMinimum = minimum;
                minimum = price;
            } else if (price < secondMinimum) {
                secondMinimum = price;
            }
        }
        if (minimum + secondMinimum > money) return money;
        return money - (minimum + secondMinimum);
    }
}
