public class NumberOfLinesToWriteInString {
    public int[] numberOfLines(int[] widths, String string) {
        int lines = 1, width = 0;
        for (char character : string.toCharArray()) {
            if (width + widths[character - 'a'] <= 100) {
                width += widths[character - 'a'];
            } else {
                lines++;
                width = widths[character - 'a'];
            }
        }
        return new int[] {lines, width};
    }
}
