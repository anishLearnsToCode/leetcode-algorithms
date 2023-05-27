// https://leetcode.com/problems/calculate-amount-paid-in-taxes
// T: O(|brackets|)
// S: O(1)

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int ceiling = 0;
        for (int i = 0 ; i < brackets.length && income > 0 ; i++) {
            final int taxableIncome = Math.min(brackets[i][0] - ceiling, income);
            income -= taxableIncome;
            ceiling = brackets[i][0];
            tax += taxableIncome * ((double) brackets[i][1] / 100);
        }
        return tax;
    }
}
