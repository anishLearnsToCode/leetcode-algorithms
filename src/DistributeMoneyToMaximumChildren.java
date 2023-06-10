// https://leetcode.com/problems/distribute-money-to-maximum-children
// T: O(1)
// S: O(1)

public class DistributeMoneyToMaximumChildren {
    public int distMoney(int money, int children) {
        if (children > money) return -1;

        int childrenReceiving8 = Math.min((money - children) / 7, children);
        final int childrenNotReceiving8 = children - childrenReceiving8;
        final int moneyLeft = money - 8 * childrenReceiving8;

        if (childrenNotReceiving8 == 1 && moneyLeft == 4) {
            childrenReceiving8--;
        }

        if (children == childrenReceiving8 && (money / 8 != children || money % 8 != 0)) {
            childrenReceiving8--;
        }

        return childrenReceiving8;
    }
}
