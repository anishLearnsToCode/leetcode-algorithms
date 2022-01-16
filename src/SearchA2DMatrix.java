// https://leetcode.com/problems/search-a-2d-matrix
// T: O(log(m*n))
// S: O(1)

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = rows * columns - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (matrix[middle / columns][middle % columns] == target) return true;
            else if (matrix[middle / columns][middle % columns] > target) right = middle - 1;
            else left = middle + 1;
        }
        return false;
    }
}
