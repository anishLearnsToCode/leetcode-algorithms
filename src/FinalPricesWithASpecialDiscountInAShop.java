import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        final Stack<Price> stack = new Stack<>();
        for (int index = 0 ; index < prices.length ; index++) {
            int price = prices[index];
            while (!stack.isEmpty() && stack.peek().price >= price) {
                Price top = stack.pop();
                prices[top.index] = top.price - price;
            }
            stack.push(new Price(price, index));
        }
        return prices;
    }

    private static final class Price {
        private final int price;
        private final int index;

        private Price(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
}
