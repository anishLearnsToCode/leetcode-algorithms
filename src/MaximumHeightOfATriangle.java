// https://leetcode.com/problems/maximum-height-of-a-triangle
// T: O(log(n) + log(m))
// S: O(1)

public class MaximumHeightOfATriangle {
    public static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(possibleRows(red, blue), possibleRows(blue, red));
    }

    private static int possibleRows(int oddRowBalls, int evenRowBalls) {
        final int evenRows = possibleEvenRows(evenRowBalls);
        final int oddRows = possibleOddRows(oddRowBalls);
        return Math.min(oddRows, evenRows + 1) + Math.min(oddRows, evenRows);
    }

    private static int possibleOddRows(int balls) {
        return (int) Math.sqrt(balls);
    }

    /*
    k - (-1 + sqrt(1 + 4b)) / 2 = 0
    k = (-1 + sqrt(1 + 4b)) / 2
     */
    private static int possibleEvenRows(int balls) {
        return (int) ((Math.sqrt(1 + 4 * balls) - 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(10, 1));
    }
}
