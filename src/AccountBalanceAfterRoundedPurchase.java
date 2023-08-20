// https://leetcode.com/problems/account-balance-after-rounded-purchase
// T: O(1)
// S: O(1)

public class AccountBalanceAfterRoundedPurchase {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        final int purchaseAmountRounded = (int) (Math.round(purchaseAmount / 10.0) * 10);
        return 100 - purchaseAmountRounded;
    }
}
