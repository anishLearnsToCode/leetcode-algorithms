public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length || (mat.length == r && mat[0].length == c)) return mat;

        int[][] result = new int[r][c];
        for (int i = 0, k = 0 ; i < mat.length ; i++) {
            for (int j = 0 ; j < mat[0].length ; j++, k++) {
                result[k / c][k % c] = mat[i][j];
            }
        }
        return result;
    }
}
