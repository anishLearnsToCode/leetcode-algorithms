// https://leetcode.com/problems/make-a-square-with-the-same-color
// T: O(1)
// S: O(1)

public class MakeASquareWithTheSameColor {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0 ; i < 2 ; i++) {
            for (int j = 0 ; j < 2 ; j++) {
                if (isPossibleToMakeSquare(grid, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPossibleToMakeSquare(char[][] grid, int i, int j) {
        int numberOfBlacks = 0;
        int numberOfWhites = 0;

        for (int row = i ; row < i + 2 ; row++) {
            for (int column = j ; column < j + 2 ; column++) {
                if (grid[row][column] == 'W') {
                    numberOfWhites++;
                } else {
                    numberOfBlacks++;
                }
            }
        }

        return numberOfBlacks == 4 || numberOfWhites == 4 || numberOfBlacks == 3 || numberOfWhites == 3;
    }
}
