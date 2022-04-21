// T: O(n)
// S: O(1)

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return catalanNumber(n);
    }

    private int catalanNumber(int n) {
        long result = 1;
        for (int i = 2 ; i <= n ; i++) {
            result *= (4L * i - 2);
            result /= i + 1;
        }
        return (int) result;
    }
}
