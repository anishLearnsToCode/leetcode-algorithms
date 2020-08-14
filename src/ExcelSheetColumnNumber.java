public class ExcelSheetColumnNumber {
    public static int titleToNumber(String column) {
        int result = 0;
        for (int index = column.length() - 1, factor = 1 ; index >= 0 ; index--, factor *= 26) {
            result += factor * (column.charAt(index) - 'A' + 1);
        }
        return result;
    }
}
