public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(17576));
    }

    public static String convertToTitle(int number) {
        return toBase26(number).toString();
    }

    private static StringBuilder toBase26(int number) {
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            result.append((char) (f(number % 26) + 'A' - 1));
            number = (number - f(number % 26)) / 26;
        }
        return result.reverse();
    }

    private static int f(int number) {
        return number == 0 ? 26 : number;
    }
}
