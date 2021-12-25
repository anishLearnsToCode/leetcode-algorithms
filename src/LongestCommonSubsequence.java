public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        final int[][] memory = new int[2][text2.length()];
        final int rows = text1.length(), columns = text2.length();

        // first row, first column
        memory[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;

        // first row
        for (int column = 1 ; column < columns ; column++) {
            memory[0][column] = text2.charAt(column) == text1.charAt(0) ? 1 : memory[0][column - 1];
        }

        int i = 1;
        // rest of table
        for (int row = 1 ; row < rows ; row++, i ^= 1) {
            for (int column = 0 ; column < text2.length() ; column++) {
                if (column == 0) {
                    memory[i][column] = text1.charAt(row) == text2.charAt(0) ? 1 : memory[i ^ 1][column];
                } else {
                    memory[i][column] = max(
                            memory[i][column - 1],
                            memory[i ^ 1][column],
                            text1.charAt(row) == text2.charAt(column) ? 1 + memory[i ^ 1][column - 1] : 0
                    );
                }
            }
        }
        return memory[i ^ 1][columns - 1];
    }

    private int max(int... values) {
        int result = 0;
        for (int value : values) {
            result = Math.max(result, value);
        }
        return result;
    }
}
