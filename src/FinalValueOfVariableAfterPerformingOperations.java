// https://leetcode.com/problems/final-value-of-variable-after-performing-operations
// T: O(|operations|)
// S: O(1)

public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            x = apply(x, operation);
        }
        return x;
    }

    private int apply(int x, String operation) {
        return switch (operation) {
            case "++X", "X++" -> x + 1;
            case "--X", "X--" -> x - 1;
            default -> x;
        };
    }
}
